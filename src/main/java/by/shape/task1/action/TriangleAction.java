package by.shape.task1.action;

import by.shape.task1.entity.Point;
import by.shape.task1.entity.Triangle;
import by.shape.task1.entity.TriangleObserver;

import java.util.Objects;

import static java.lang.Math.*;

public class TriangleAction implements TriangleObserver {

    private double accuracy = 0.0000001;

    private double sideA, sideB, sideC;
    private double area, perimeter;
    private boolean isRight, isIsosceles, isEquilateral, isAcuteAngle, isObtuseAngle;

    public TriangleAction(Triangle triangle) {


        triangleUpdate(triangle);

    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isIsosceles() {
        return isIsosceles;
    }

    public boolean isEquilateral() {
        return isEquilateral;
    }

    public boolean isAcuteAngle() {
        return isAcuteAngle;
    }

    public boolean isObtuseAngle() {
        return isObtuseAngle;
    }

    private void calculateSides(Triangle triangle) {

        sideA = side(triangle.getPointA(), triangle.getPointB());
        sideB = side(triangle.getPointB(), triangle.getPointC());
        sideC = side(triangle.getPointC(), triangle.getPointA());

    }

    private double calculateArea(Triangle triangle) {
        double area = sqrt(halfPerimeter(triangle) * (halfPerimeter(triangle) - sideA) *
                (halfPerimeter(triangle) - sideB) *
                (halfPerimeter(triangle) - sideC));

        return area;
    }

    private double halfPerimeter(Triangle triangle) {
        return calculatePerimeter(triangle) / 2;
    }

    private double calculatePerimeter(Triangle triangle) {
        return sideA + sideB + sideC;
    }

    private boolean calculateRight(Triangle triangle) {

        double hypotenuse = Double.max(Double.max(sideA, sideB), sideC);
        double legOne, legTwo;

        if (abs(hypotenuse - sideA) <= accuracy) {
            legOne = sideB;
            legTwo = sideC;
        } else if (abs(hypotenuse - sideB) <= accuracy) {
            legOne = sideA;
            legTwo = sideC;
        } else {
            legOne = sideA;
            legTwo = sideB;
        }

        boolean isRight = abs(pow(legOne, 2) + pow(legTwo, 2) - pow(hypotenuse, 2)) <= accuracy;

        return isRight;

    }

    private boolean calculateIsosceles(Triangle triangle) {

        boolean isIsosceles = false;

        if (abs(sideA - sideB) <= accuracy) {
            isIsosceles = true;
        } else if (abs(sideA - sideC) <= accuracy) {
            isIsosceles = true;
        } else if (abs(sideB - sideC) <= accuracy) {
            isIsosceles = true;
        }

        return isIsosceles;
    }

    private boolean calculateEquilateral(Triangle triangle) {

        return abs(sideA - sideC) <= accuracy && abs(sideB - sideC) <= accuracy;

    }

    private boolean calculateAcuteAngle(Triangle triangle) {

        double rightAngle = 90;

        double angleA = angleInDegreesBetweenTwoSides(sideB, sideC, sideA);
        double angleB = angleInDegreesBetweenTwoSides(sideA, sideC, sideB);
        double angleC = angleInDegreesBetweenTwoSides(sideA, sideB, sideC);

        return angleA < rightAngle && angleB < rightAngle && angleC < rightAngle;


    }

    private boolean calculateObtuseAngle(Triangle triangle) {

        double rightAngle = 90;
        boolean isObtuse = false;

        double angleA = angleInDegreesBetweenTwoSides(sideB, sideC, sideA);
        double angleB = angleInDegreesBetweenTwoSides(sideA, sideC, sideB);
        double angleC = angleInDegreesBetweenTwoSides(sideA, sideB, sideC);

        if (angleA > rightAngle) {
            isObtuse = true;
        } else if (angleB > rightAngle) {
            isObtuse = true;
        } else if (angleC > rightAngle) {
            isObtuse = true;
        }

        return isObtuse;

    }


    public static double side(Point point1, Point point2) {
        return sqrt(pow((point1.getX() - point2.getX()), 2) + pow((point1.getY() - point2.getY()), 2));
    }

    private static double angleInDegreesBetweenTwoSides(double lengthOfAdjacentSideOne, double lengthOfAdjacentSideTwo, double lengthOfOppositeSide) {

        double angleInDegrees = toDegrees(acos((pow(lengthOfAdjacentSideOne, 2) + pow(lengthOfAdjacentSideTwo, 2) - pow(lengthOfOppositeSide, 2)) / (2 * lengthOfAdjacentSideOne * lengthOfAdjacentSideTwo)));

        return angleInDegrees;

    }


    @Override
    public void triangleUpdate(Triangle triangle) {
        calculateSides(triangle);
        area = calculateArea(triangle);
        perimeter = calculatePerimeter(triangle);
        isRight = calculateRight(triangle);
        isIsosceles = calculateIsosceles(triangle);
        isEquilateral = calculateEquilateral(triangle);
        isAcuteAngle = calculateAcuteAngle(triangle);
        isObtuseAngle = calculateObtuseAngle(triangle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TriangleAction)) return false;
        TriangleAction action = (TriangleAction) o;
        return Double.compare(action.accuracy, accuracy) == 0 &&
                Double.compare(action.sideA, sideA) == 0 &&
                Double.compare(action.sideB, sideB) == 0 &&
                Double.compare(action.sideC, sideC) == 0 &&
                Double.compare(action.area, area) == 0 &&
                Double.compare(action.perimeter, perimeter) == 0 &&
                isRight == action.isRight &&
                isIsosceles == action.isIsosceles &&
                isEquilateral == action.isEquilateral &&
                isAcuteAngle == action.isAcuteAngle &&
                isObtuseAngle == action.isObtuseAngle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accuracy, sideA, sideB, sideC, area, perimeter, isRight, isIsosceles, isEquilateral, isAcuteAngle, isObtuseAngle);
    }
}
