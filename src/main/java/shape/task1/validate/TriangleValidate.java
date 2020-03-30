package shape.task1.validate;

import shape.task1.entity.Point;
import shape.task1.exception.TriangleArgumentException;
import shape.task1.exception.TriangleReadingValidationException;

import static java.lang.Math.abs;
import static shape.task1.service.TriangleService.side;

public class TriangleValidate {

    public boolean validateParsing(String line) {

        String[] splittingValues = line.split(" ");

        if (splittingValues.length != 6) {
            throw new TriangleReadingValidationException("Incorrect length of line.");
        }

        try {

            for (String value : splittingValues) {

                Double.parseDouble(value);

            }

        } catch (NumberFormatException e) {

            throw new TriangleReadingValidationException("Incorrect point value.");
        }

        return true;

    }

    public boolean validateValues(Point pointA, Point pointB, Point pointC) {


        if (isLine(pointA, pointB, pointC)) {
            throw new TriangleArgumentException("Point belong to straight line.");
        }

        if (!isSumLessOfSidesMoreThenBiggestSide(pointA, pointB, pointC)) {
            throw new TriangleArgumentException("The sum of the two smaller sides of the triangle is less then the third side.");
        }

        return true;


    }

    private boolean isSumLessOfSidesMoreThenBiggestSide(Point pointA, Point pointB, Point pointC) {

        double sideA = side(pointA, pointB);
        double sideB = side(pointB, pointC);
        double sideC = side(pointC, pointA);

        return sideA + sideB > sideC &&
                sideB + sideC > sideA &&
                sideA + sideC > sideB;

    }

    private boolean isLine(Point topA, Point topB, Point topC) {
        double accuracy = 0.0000001;

        return abs((topC.getY() - topA.getY()) * (topB.getX() - topA.getX()) - (topB.getY() - topA.getY()) * (topC.getX() - topA.getX())) <= accuracy;
    }


}
