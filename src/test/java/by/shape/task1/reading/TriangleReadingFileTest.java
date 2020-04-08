package by.shape.task1.reading;

import by.shape.task1.entity.Point;
import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.ReadingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TriangleReadingFileTest {

    TriangleReading triangleReading;
    List<Triangle> testingCorrectTriangles;
    static Logger logger = LogManager.getLogger();

    @BeforeClass
    public void setUp() {

        Path pathToTestFile = Path.of("src/test/java/resources/test.txt");
        triangleReading = new TriangleReadingFile(pathToTestFile);

        testingCorrectTriangles = new ArrayList<>();
        testingCorrectTriangles.add(Triangle.createByPoints(new Point(2, 3), new Point(41, 51), new Point(61, 71)));
        testingCorrectTriangles.add(Triangle.createByPoints(new Point(2, 3), new Point(42, 52), new Point(62, 72)));
        testingCorrectTriangles.add(Triangle.createByPoints(new Point(2, 3), new Point(43, 53), new Point(63, 73)));
        testingCorrectTriangles.add(Triangle.createByPoints(new Point(2, 3), new Point(44, 54), new Point(64, 74)));
        testingCorrectTriangles.add(Triangle.createByPoints(new Point(2, 3), new Point(45, 55), new Point(65, 75)));

    }

    @Test
    public void testGetTrianglesCorrectValues() {

        List<Triangle> triangles;
        try {
            triangles = triangleReading.getTriangles();

            assertEquals(triangles, testingCorrectTriangles);

        } catch (ReadingException e) {
            logger.error("Error. ReadingException");
        }

    }

    @Test(expectedExceptions = ReadingException.class)
    public void testGetTriangleThrowException() throws ReadingException {

        Path pathThrowing = Path.of("testTriangle.txt");
        TriangleReading triangleReadingThrowing = new TriangleReadingFile(pathThrowing);

        triangleReadingThrowing.getTriangles();

    }


}


