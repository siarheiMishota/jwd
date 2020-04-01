package shape.task1.service;

import shape.task1.entity.Point;
import shape.task1.entity.Triangle;
import shape.task1.exception.TriangleNullPointerException;

import static java.lang.Math.*;

public class TriangleService {

    private double accuracy = 0.0000001;

    private Triangle triangle;
    private double sideA, sideB, sideC;

    public TriangleService(Triangle triangle) {

        if (triangle == null) {
            throw new TriangleNullPointerException("Triangle doesn't exist");
        }

        this.triangle = triangle;
        calculateSides();
    }

    private void calculateSides() {

        sideA = side(triangle.getPointA(), triangle.getPointB());
        sideB = side(triangle.getPointB(), triangle.getPointC());
        sideC = side(triangle.getPointC(), triangle.getPointA());

    }

    public double area() {
        double area=sqrt(halfPerimeter() * (halfPerimeter() - sideA) *
                (halfPerimeter() - sideB) *
                (halfPerimeter() - sideC));

        return area;
    }

    private double halfPerimeter() {
        return perimeter() / 2;
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }

    public boolean isRight() {

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

    public boolean isIsosceles() {

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

    public boolean isEquilateral() {

        return abs(sideA - sideC) <= accuracy && abs(sideB - sideC) <= accuracy;

    }

    public boolean isAcuteAngle() {

        double rightAngle = 90;

        double angleA = angleInDegreesBetweenTwoSides(sideB, sideC, sideA);
        double angleB = angleInDegreesBetweenTwoSides(sideA, sideC, sideB);
        double angleC = angleInDegreesBetweenTwoSides(sideA, sideB, sideC);

        return angleA < rightAngle && angleB < rightAngle && angleC < rightAngle;


    }

    public boolean isObtuseAngle() {

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


}
