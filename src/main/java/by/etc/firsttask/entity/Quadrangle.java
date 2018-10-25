package by.etc.firsttask.entity;


import by.etc.firsttask.repository.NotifyEventArgs;
import by.etc.firsttask.repository.QuadrangleRepository;
import by.etc.firsttask.repository.RepositoryEntryStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Flow;

public class Quadrangle implements Serializable, Flow.Publisher {
    private static final long serialVersionUID = 1947573967463857669L;

    private Integer id;
    private String name;

    private Point vertex1;
    private Point vertex2;
    private Point vertex3;
    private Point vertex4;

    private static List<Flow.Subscriber> subscribers = List.of(QuadrangleRepository.getInstance());

    private static final Logger LOGGER = LogManager.getLogger(Quadrangle.class.getName());

    public Quadrangle(Point point1, Point point2, Point point3, Point point4) {
        vertex1 = point1;
        vertex2 = point2;
        vertex3 = point3;
        vertex4 = point4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        LOGGER.info("Name was changed");
        notifyAboutChange(this);
    }

    public Point getVertex1() {
        return vertex1;
    }

    public void setVertex1(Point vertex1) {
        this.vertex1 = vertex1;
        LOGGER.info("Vertex was changed");
        notifyAboutChange(this);
    }

    public Point getVertex2() {
        return vertex2;
    }

    public void setVertex2(Point vertex2) {
        this.vertex2 = vertex2;
        LOGGER.info("Vertex was changed");
        notifyAboutChange(this);
    }

    public Point getVertex3() {
        return vertex3;
    }

    public void setVertex3(Point vertex3) {
        this.vertex3 = vertex3;
        LOGGER.info("Vertex was changed");
        notifyAboutChange(this);
    }

    public Point getVertex4() {
        return vertex4;
    }

    public void setVertex4(Point vertex4) {
        this.vertex4 = vertex4;
        LOGGER.info("Vertex was changed");
        notifyAboutChange(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Quadrangle quadrangle = (Quadrangle) obj;
        return quadrangle.getVertex1() == this.getVertex1() &&
                quadrangle.getVertex2() == this.getVertex2() &&
                quadrangle.getVertex3() == this.getVertex3() &&
                quadrangle.getVertex4() == this.getVertex4();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = new Random().nextInt(255);
        result = prime * result + this.getVertex1().hashCode();
        result = prime * result + this.getVertex2().hashCode();
        result = prime * result + this.getVertex3().hashCode();
        result = prime * result + this.getVertex4().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Entity %s [id: %d, name: %s, vertex 1: %s, vertex 2: %s, vertex 3: %s, vertex 4: %s]",
                getClass().getSimpleName(), getId(), getName(), getVertex1().toString(), getVertex2().toString(),
                getVertex3().toString(), getVertex4().toString());
    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        subscribers.add(subscriber);
        LOGGER.info("Adding subscriber is done!");
    }

    private void notifyAboutChange(Quadrangle quadrangle) {
        NotifyEventArgs eventArgs = new NotifyEventArgs(quadrangle, RepositoryEntryStatus.UPDATED);
        subscribers.forEach(current -> {
            try {
                current.onNext(eventArgs);
                current.onComplete();
            } catch (Exception e) {
                current.onError(e);
            }
        });
    }
}