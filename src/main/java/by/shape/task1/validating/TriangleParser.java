package by.shape.task1.validating;

import by.shape.task1.entity.Point;
import by.shape.task1.entity.Triangle;

public class TriangleParser {

    private static String spliterator=" ";


    private TriangleValidate triangleValidate;

    public TriangleParser(TriangleValidate triangleValidate) {
        this.triangleValidate = triangleValidate;
    }

    public Triangle parsing(String line){


        if (triangleValidate.validateLine(line)) {
            int positionNumber = 0;
            String[] splittingLine=line.split(spliterator);
            int id = Integer.parseInt(splittingLine[positionNumber++]);
            double pointAX = Double.parseDouble(splittingLine[positionNumber++]);
            double pointAY = Double.parseDouble(splittingLine[positionNumber++]);
            double pointBX = Double.parseDouble(splittingLine[positionNumber++]);
            double pointBY = Double.parseDouble(splittingLine[positionNumber++]);
            double pointCX = Double.parseDouble(splittingLine[positionNumber++]);
            double pointCY = Double.parseDouble(splittingLine[positionNumber++]);

            Point pointA = new Point(pointAX, pointAY);
            Point pointB = new Point(pointBX, pointBY);
            Point pointC = new Point(pointCX, pointCY);

            if (triangleValidate.validatePointsBelongToSingleLine(pointA,pointB,pointC)){

                Triangle triangle = new Triangle(id, pointA, pointB, pointC);
                return triangle;
            }


        }else {

//           Logger _______________________________________________________________________________________________________________________________________

        }

        return null;

    }
}
