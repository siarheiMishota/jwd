package by.shape.task1.validating;

import by.shape.task1.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

import static java.lang.Math.abs;

public class TriangleValidate {

    final static String patternCorrectValues = "\\s*((-?\\d+\\.?\\d*)\\s+){5}(-?\\d+\\.?\\d*)\\s*";

    final static Logger logger = LogManager.getLogger();


    public boolean validateLine(String line) {

        if (Pattern.matches(patternCorrectValues, line)) {
            return true;
        }

        logger.warn("Line isn't correct: " + line);

        return false;

    }


    public boolean validatePointsBelongToSingleLine(Point topA, Point topB, Point topC) {
        double accuracy = 0.0000001;

        if (abs((topC.getY() - topA.getY()) * (topB.getX() - topA.getX()) - (topB.getY() - topA.getY()) * (topC.getX() - topA.getX())) > accuracy) {
            return true;
        }

        logger.warn("All point belong to single line: " + topA + topB + topC);

        return false;
    }


}
