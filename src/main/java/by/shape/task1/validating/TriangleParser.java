package by.shape.task1.validating;

import by.shape.task1.entity.Point;
import by.shape.task1.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleParser {

    final static Logger logger = LogManager.getLogger();

    private static String spliterator = " ";


    private TriangleValidate triangleValidate;

    public TriangleParser(TriangleValidate triangleValidate) {
        this.triangleValidate = triangleValidate;
    }

    public Triangle parsing(String line) {


        if (triangleValidate.validateLine(line)) {
            int positionNumber = 0;
            String[] splittingLine = line.split(spliterator);
            double pointAX = Double.parseDouble(splittingLine[positionNumber++]);
            double pointAY = Double.parseDouble(splittingLine[positionNumber++]);
            double pointBX = Double.parseDouble(splittingLine[positionNumber++]);
            double pointBY = Double.parseDouble(splittingLine[positionNumber++]);
            double pointCX = Double.parseDouble(splittingLine[positionNumber++]);
            double pointCY = Double.parseDouble(splittingLine[positionNumber++]);

            Point pointA = new Point(pointAX, pointAY);
            Point pointB = new Point(pointBX, pointBY);
            Point pointC = new Point(pointCX, pointCY);

            if (triangleValidate.validatePointsBelongToSingleLine(pointA, pointB, pointC)) {

                Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);
                return triangle;
            }


        } else {

            logger.warn(line+":  the line was not recognized");
        }

        return null;

    }
}
