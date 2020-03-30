package shape.task1.entity;

public class Triangle {

    private int id;
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(int id, Point pointA, Point pointB, Point pointC) {
        this.id = id;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return pointA.equals(triangle.pointA) &&
                pointB.equals(triangle.pointB) &&
                pointC.equals(triangle.pointC);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + Integer.hashCode(id);
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


}
