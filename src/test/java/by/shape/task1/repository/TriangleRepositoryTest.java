package by.shape.task1.repository;

import by.shape.task1.entity.Point;
import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.TriangleRepositoryException;
import by.shape.task1.reading.TriangleReading;
import by.shape.task1.reading.TriangleReadingFile;
import by.shape.task1.repository.specification.IdSpecification;
import by.shape.task1.repository.specification.NotSpecification;
import by.shape.task1.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TriangleRepositoryTest {


    Path path = Path.of("src/main/resources/triangles.txt");
    static Logger logger = LogManager.getLogger();

    TriangleReading triangleReading = new TriangleReadingFile(path);
    TriangleRepository repository;

    @BeforeMethod
    public void setUp() {
        try {
            repository = TriangleRepository.getInstance(triangleReading);
        } catch (TriangleRepositoryException e) {

            logger.error("Error in repository test for expected");

        }


    }


    @Test
    public void testGetInstance() throws TriangleRepositoryException {

        TriangleReading triangleReading = new TriangleReadingFile(path);
        TriangleRepository expectedRepository = TriangleRepository.getInstance(triangleReading);

        assertEquals(repository, expectedRepository);

    }

    @Test
    public void testGetInstanceSecond() {
        try {
            TriangleRepository expectedRepository = TriangleRepository.getInstance(triangleReading);

            assertEquals(repository, expectedRepository);


        } catch (TriangleRepositoryException e) {
            logger.error("Triangle repository exception");
        }

    }

    @Test
    public void testAdd() {

        Triangle addingTriangle = Triangle.createByPoints(new Point(10, 30), new Point(40, 90), new Point(63, 192));
        repository.add(addingTriangle);

        Specification idSpecification = new IdSpecification(addingTriangle.getId());

        List<Triangle> queryTriangle = repository.query(idSpecification);
        assertEquals(addingTriangle, queryTriangle.get(0));

        try {
            Field fieldRepository = TriangleRepository.class.getDeclaredField("triangleRepository");
            fieldRepository.setAccessible(true);
            fieldRepository.set(TriangleRepository.class, null);

            Field fieldIdTriangle = Triangle.class.getDeclaredField("generateID");
            fieldIdTriangle.setAccessible(true);
            fieldIdTriangle.setInt(TriangleRepository.class, 0);

            System.out.println();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testRemove() {

        Triangle removingTriangle = Triangle.createByPoints(new Point(-2, 4), new Point(-1, 7), new Point(3, 1));

        repository.remove(removingTriangle);

        Specification notSpecification = new NotSpecification();


        List<Triangle> queryTriangles = repository.query(notSpecification);
        int actualSize = 9;
        assertEquals(actualSize, queryTriangles.size());

        try {
            Field fieldRepository = TriangleRepository.class.getDeclaredField("triangleRepository");
            fieldRepository.setAccessible(true);
            fieldRepository.set(TriangleRepository.class, null);

            Field fieldIdTriangle = Triangle.class.getDeclaredField("generateID");
            fieldIdTriangle.setAccessible(true);
            fieldIdTriangle.setInt(TriangleRepository.class, 0);

            System.out.println();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testQueryIdSpecification() {

        Triangle triangle = Triangle.createByPoints(new Point(-2, 4), new Point(-1, 7), new Point(3, 1));

        Specification idSpecification = new IdSpecification(9);
        List<Triangle> queryTriangle = repository.query(idSpecification);
        assertEquals(triangle, queryTriangle.get(0));


    }


}
