package by.etc.firsttask.storage;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.quadrangleAction.QuadrangleAction;
import by.etc.firsttask.quadrangleAction.QuadrangleActionImpl;
import by.etc.firsttask.registrar.QuadrangleRegistrar;
import by.etc.firsttask.repository.NotifyEventArgs;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.repository.RepositoryEntryStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Flow;

public class QuadrangleStorage implements Flow.Subscriber {
    private Map<Integer, QuadrangleRegistrar> storage;
    private QuadrangleAction action;

    private static QuadrangleStorage instance;

    private static final Logger LOGGER = LogManager.getLogger(QuadrangleStorage.class.getName());

    private QuadrangleStorage() {
        storage = new HashMap<>();
        action = new QuadrangleActionImpl();
    }

    public static QuadrangleStorage getInstance() {
        if (instance == null) {
            instance = new QuadrangleStorage();
            LOGGER.info("Create quadrangles' storage");
        }
        return instance;
    }

    public Map<Integer, QuadrangleRegistrar> getStorage() {
        return storage;
    }

    private QuadrangleRegistrar recalculate(Quadrangle quadrangle) {
        Double newSquare = action.calculateSquare(quadrangle);
        Double newPerimeter = action.calculatePerimeter(quadrangle);
        LOGGER.info("Recalculate for " + quadrangle.getId() + " square " + newSquare + " perimeter " + newPerimeter);
        return new QuadrangleRegistrar(newSquare, newPerimeter);

    }

    public void add(Integer id, QuadrangleRegistrar registrar) {
        storage.put(id, registrar);
        LOGGER.info("Adding in storage is done");
    }

    public void update(Integer id, QuadrangleRegistrar registrar) {
        for (Map.Entry<Integer, QuadrangleRegistrar> record : storage.entrySet()) {
            if (record.getKey().equals(id)) {
                record.setValue(registrar);
                LOGGER.info("Updating in storage is done");
            }
        }
    }

    public void remove(Integer quadrangleId) {
        storage.remove(quadrangleId);
        LOGGER.info("Removing in storage is done");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(Object item) {
        NotifyEventArgs eventArgs = (NotifyEventArgs) item;
        Quadrangle quadrangle = eventArgs.getQuadrangle();
        RepositoryEntryStatus status = eventArgs.getStatus();
        chooseEvent(quadrangle, status);
    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.error("Something is wrong!" + throwable.fillInStackTrace());
    }

    @Override
    public void onComplete() {
        LOGGER.info("Notify about changing is done!");
    }

    private void chooseEvent(Quadrangle quadrangle, RepositoryEntryStatus status) {
        if (status == RepositoryEntryStatus.ADDED) {
            QuadrangleRegistrar registrar = recalculate(quadrangle);
            add(quadrangle.getId(), registrar);
        } else if (status == RepositoryEntryStatus.UPDATED) {
            QuadrangleRegistrar registrar = recalculate(quadrangle);
            update(quadrangle.getId(), registrar);
        } else if(status == RepositoryEntryStatus.DELETED) {
            remove(quadrangle.getId());
        }
    }
}
