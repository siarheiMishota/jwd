package by.shape.task1.validating;

import by.shape.task1.entity.Point;
import by.shape.task1.entity.Triangle;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class TriangleParserTest {

    Triangle actualTriangle = Triangle.createByPoints(new Point(0, 0), new Point(10, 15), new Point(3, 9));

    @Test
    public void testCorrectParsing() {

        TriangleValidate validate = new TriangleValidate();
        TriangleParser parser = new TriangleParser(validate);

        String line = "0 0 10 15 3 9";

        Triangle expected = parser.parsing(line);

        boolean comparisionResult=actualTriangle.getPointA().equals(expected.getPointA())&&
                actualTriangle.getPointB().equals(expected.getPointB())&&
                actualTriangle.getPointC().equals(expected.getPointC());

        assertTrue(comparisionResult);

    }

    @Test
    public void testInCorrectParsing() {

        TriangleValidate validate = new TriangleValidate();
        TriangleParser parser = new TriangleParser(validate);

        String line = "0 0 0 10 15 3 9";

        Triangle expected = parser.parsing(line);

        assertNull(expected);

    }

    @Test
    public void testInCorrectParsingWithNumberElements() {

        TriangleValidate validate = new TriangleValidate();
        TriangleParser parser = new TriangleParser(validate);

        String line = "0 0 0 10 15 3 9";

        Triangle expected = parser.parsing(line);

        assertNull(expected);

    }

    @Test
    public void testInCorrectParsingWhenPointsBelongLine() {

        TriangleValidate validate = new TriangleValidate();
        TriangleParser parser = new TriangleParser(validate);

        String line = "0 0 10 10 32 32";

        Triangle expected = parser.parsing(line);

        assertNull(expected);

    }
}
