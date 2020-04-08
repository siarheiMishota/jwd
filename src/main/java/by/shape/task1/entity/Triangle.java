package by.shape.task1.entity;

import java.util.Objects;

public class Triangle implements TriangleObservable {

    private static long generateID = 0;

    private long id;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private TriangleObserver observer;

    private Triangle(Point pointA, Point pointB, Point pointC) {
        this.id = generateID++;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public static Triangle createByPoints(Point pointA, Point pointB, Point pointC) {

        return new Triangle(pointA, pointB, pointC);

    }

    public long getId() {
        return id;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        notifyObserver();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObserver();
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        notifyObserver();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(pointA, triangle.pointA) &&
                Objects.equals(pointB, triangle.pointB) &&
                Objects.equals(pointC, triangle.pointC) &&
                Objects.equals(observer, triangle.observer);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + Long.hashCode(id);
        result = prime * result + pointA.hashCode();
        result = prime * result + pointB.hashCode();
        result = prime * result + pointC.hashCode();

        return result;

    }


    @Override
    public String toString() {
        return String.format("%6d  A(%.2f; %.2f), B(%.2f; %.2f), C(%.2f; %.2f)", id,
                pointA.getX(), pointA.getY(), pointB.getX(), pointB.getY(), pointC.getX(), pointC.getY());
    }


    @Override
    public void attach(TriangleObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach(TriangleObserver observer) {
        observer = null;
    }

    @Override
    public void notifyObserver() {

        if (observer != null) {
            observer.triangleUpdate(this);
        }

    }
}
