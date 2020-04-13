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
    static Logger logger = LogManager.getLogger();

    @BeforeClass
    public void setUp() {

        Path pathToTestFile = Path.of("src/test/java/resources/test.txt");
        triangleReading = new TriangleReadingFile(pathToTestFile);


    }

    @Test
    public void testGetTrianglesCorrectValues() {

        int actualNumber=10;
        List<Triangle> triangles;
        try {
            triangles = triangleReading.getTriangles();

            assertEquals(actualNumber, triangles.size());

        } catch (ReadingException e) {
            logger.error("Error. ReadingException. " +e);
        }

    }

    @Test(expectedExceptions = ReadingException.class)
    public void testGetTriangleThrowException() throws ReadingException {

        Path pathThrowing = Path.of("testTriangle.txt");
        TriangleReading triangleReadingThrowing = new TriangleReadingFile(pathThrowing);

        triangleReadingThrowing.getTriangles();

    }


}


