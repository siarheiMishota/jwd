package by.shape.task1.entity;

public interface TriangleObservable {

    void attach(TriangleObserver observer);
    void detach(TriangleObserver observer);
    void notifyObserver();
}
