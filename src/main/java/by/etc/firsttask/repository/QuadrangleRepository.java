package by.etc.firsttask.repository;

import by.etc.firsttask.entity.Quadrangle;
import by.etc.firsttask.specification.QuadrangleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class QuadrangleRepository implements Flow.Processor {
    private List<Quadrangle> quadrangles;
    private List<Flow.Subscriber> subscribers;
    private static QuadrangleRepository instance;

    private static final Logger LOGGER = LogManager.getLogger(QuadrangleRepository.class.getName());

    private QuadrangleRepository() {
        quadrangles = new ArrayList<>();
        subscribers = new ArrayList<>();
    }

    public static QuadrangleRepository getInstance() {
        if (instance == null) {
            LOGGER.info("Create quadrangles' repository");
            instance = new QuadrangleRepository();
        }
        return instance;
    }

    public List<Quadrangle> getQuadrangles() {
        return quadrangles;
    }

    public void add(Quadrangle quadrangle) {
        quadrangles.add(quadrangle);
        notifyAboutChange(quadrangle, RepositoryEntryStatus.ADDED);
        LOGGER.info("Notify about adding quadrangle");
    }

    public void remove(Quadrangle quadrangle) {
        quadrangles.remove(quadrangle);
        notifyAboutChange(quadrangle, RepositoryEntryStatus.DELETED);
        LOGGER.info("Notify about removing quadrangle");
    }

    public void remove(QuadrangleSpecification specification) {
        List<Quadrangle> resultRemoving = specification.execute(this);
        for(Quadrangle currentQuad : resultRemoving) {
            notifyAboutChange(currentQuad, RepositoryEntryStatus.DELETED);
        }
        LOGGER.info("Notify about removing quadrangle");
    }

    public List<Quadrangle> query(QuadrangleSpecification specification) {
        List<Quadrangle> resultQuery = specification.execute(this);
        LOGGER.info("Query according to the specification is done");
        return resultQuery;
    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        LOGGER.info("Adding subscriber is done");
        subscribers.add(subscriber);
    }

    private void notifyAboutChange(Quadrangle quadrangle, RepositoryEntryStatus status) {
        NotifyEventArgs eventArgs = new NotifyEventArgs(quadrangle, status);
        subscribers.forEach(current -> {
            try {
                current.onNext(eventArgs);
                current.onComplete();
            } catch (Exception e) {
                current.onError(e);
            }
        });
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {}

    @Override
    public void onNext(Object item) {
        NotifyEventArgs eventArgs = (NotifyEventArgs) item;
        notifyAboutChange(eventArgs.getQuadrangle(), eventArgs.getStatus());
    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.error("Something is wrong!" + throwable.fillInStackTrace());
    }

    @Override
    public void onComplete() {
        LOGGER.info("Notify about changing is done");
    }

}
