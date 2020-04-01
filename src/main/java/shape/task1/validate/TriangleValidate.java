package shape.task1.validate;

import shape.task1.entity.Point;
import shape.task1.exception.TriangleValidateException;

import static java.lang.Math.abs;
import static shape.task1.service.TriangleService.side;

public class TriangleValidate {

    public void validate(String line) {

        String[] splittingLine = line.split(" ");

        validateNumberOfElements(splittingLine);

        Point pointA, pointB, pointC;

        try {
            double pointAX, pointAY, pointBX, pointBY, pointCX, pointCY;

            int positionNumber = 0;

            int id = Integer.parseInt(splittingLine[positionNumber++]);
            pointAX = Double.parseDouble(splittingLine[positionNumber++]);
            pointAY = Double.parseDouble(splittingLine[positionNumber++]);
            pointBX = Double.parseDouble(splittingLine[positionNumber++]);
            pointBY = Double.parseDouble(splittingLine[positionNumber++]);
            pointCX = Double.parseDouble(splittingLine[positionNumber++]);
            pointCY = Double.parseDouble(splittingLine[positionNumber++]);

            pointA = new Point(pointAX, pointAY);
            pointB = new Point(pointBX, pointBY);
            pointC = new Point(pointCX, pointCY);

        } catch (NumberFormatException e) {
            throw new TriangleValidateException("Incorrect point value.", e);
        }

        validatePointsBelongToSingleLine(pointA, pointB, pointC);

    }

    private void validateNumberOfElements(String[] splittingValues) {
        int numberOfValues = 7;
        if (splittingValues.length != numberOfValues) {
            throw new TriangleValidateException("Incorrect length of line.");
        }
    }




    private void validatePointsBelongToSingleLine(Point topA, Point topB, Point topC) {
        double accuracy = 0.0000001;

        if (abs((topC.getY() - topA.getY()) * (topB.getX() - topA.getX()) - (topB.getY() - topA.getY()) * (topC.getX() - topA.getX())) <= accuracy) {
            throw new TriangleValidateException("All point belong to single line");
        }

    }


}
