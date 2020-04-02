package by.shape.task1.dao;

import by.shape.task1.entity.Point;
import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.DaoIOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TriangleDAOFileTest {
    TriangleDAO triangleDAO;
    List<Triangle> testingCorrectTriangles;

    @BeforeClass
    public void setUp() {

        Path pathToTestFile = Path.of("src/test/java/resources/test.txt");
        triangleDAO = new TriangleDAOFile(pathToTestFile);

        testingCorrectTriangles = new ArrayList<>();
        testingCorrectTriangles.add(new Triangle(11, new Point(2, 3), new Point(41, 51), new Point(61, 71)));
        testingCorrectTriangles.add(new Triangle(12, new Point(2, 3), new Point(42, 52), new Point(62, 72)));
        testingCorrectTriangles.add(new Triangle(13, new Point(2, 3), new Point(43, 53), new Point(63, 73)));
        testingCorrectTriangles.add(new Triangle(14, new Point(2, 3), new Point(44, 54), new Point(64, 74)));
        testingCorrectTriangles.add(new Triangle(15, new Point(2, 3), new Point(45, 55), new Point(65, 75)));

    }

    @Test
    public void testGetTrianglesCorrectValues() {

        List<Triangle> triangles;
        try {
            triangles = triangleDAO.getTriangles();
            assertEquals(triangles, testingCorrectTriangles);

        } catch (DaoIOException e) {
//            _________________________________________________________________________________________________________
        }

    }

    @Test(expectedExceptions = DaoIOException.class)
    public void testGetTriangleThrowException() throws DaoIOException {

        Path pathThrowing = Path.of("testTriangle.txt");
        TriangleDAO triangleDAOThrowing = new TriangleDAOFile(pathThrowing);

        triangleDAOThrowing.getTriangles();

    }

    @Test
    public void testSaveTriangles() {
    }
}


