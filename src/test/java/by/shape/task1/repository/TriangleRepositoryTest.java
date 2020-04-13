package by.shape.task1.repository;

import by.shape.task1.action.TriangleAction;
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
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class TriangleRepositoryTest {


    Path path = Path.of("src/test/java/resources/test.txt");
    static Logger logger = LogManager.getLogger();

    TriangleReading triangleReading = new TriangleReadingFile(path);
    TriangleRepository repository;

    @BeforeMethod
    public void setUp() throws TriangleRepositoryException {
        repository = TriangleRepository.getInstance(triangleReading);


    }


    @Test
    public void testGetInstance() throws TriangleRepositoryException {

        TriangleReading triangleReading = new TriangleReadingFile(path);
        TriangleRepository expectedRepository = TriangleRepository.getInstance(triangleReading);

        assertEquals(repository, expectedRepository);


    }

    @Test
    public void testGetInstanceSecond() throws TriangleRepositoryException {

        TriangleRepository expectedRepository = TriangleRepository.getInstance(triangleReading);

        assertEquals(repository, expectedRepository);


    }

    @Test(expectedExceptions = TriangleRepositoryException.class)
    public void testGetInstanceThrowException() throws TriangleRepositoryException, NoSuchFieldException, IllegalAccessException {

        Field fieldRepository = TriangleRepository.class.getDeclaredField("triangleRepository");
        fieldRepository.setAccessible(true);
        fieldRepository.set(TriangleRepository.class, null);

        TriangleReading readingWithException = new TriangleReadingFile(Path.of("throwException.txt"));

        TriangleRepository.getInstance(readingWithException);

        fieldRepository.set(TriangleRepository.class, null);


    }

    @Test
    public void testAdd() throws NoSuchFieldException, IllegalAccessException {

        Triangle addingTriangle = Triangle.createByPoints(new Point(10, 30), new Point(40, 90), new Point(63, 192));
        repository.add(addingTriangle);

        Specification idSpecification = new IdSpecification(addingTriangle.getId());

        List<Triangle> queryTriangle = repository.query(idSpecification);
        assertEquals(addingTriangle, queryTriangle.get(0));

        Field fieldRepository = TriangleRepository.class.getDeclaredField("triangleRepository");
        fieldRepository.setAccessible(true);
        fieldRepository.set(TriangleRepository.class, null);

        Field fieldIdTriangle = Triangle.class.getDeclaredField("generateID");
        fieldIdTriangle.setAccessible(true);
        fieldIdTriangle.setInt(TriangleRepository.class, 0);

        System.out.println();


    }

    @Test
    public void testRemove() throws NoSuchFieldException, IllegalAccessException {

        Triangle removingTriangle = Triangle.createByPoints(new Point(-2, 4), new Point(-1, 7), new Point(3, 1));

        repository.remove(removingTriangle);

        Specification notSpecification = new NotSpecification();


        List<Triangle> queryTriangles = repository.query(notSpecification);
        int actualSize = 9;
        assertEquals(actualSize, queryTriangles.size());

        Field fieldRepository = TriangleRepository.class.getDeclaredField("triangleRepository");
        fieldRepository.setAccessible(true);
        fieldRepository.set(TriangleRepository.class, null);

        Field fieldIdTriangle = Triangle.class.getDeclaredField("generateID");
        fieldIdTriangle.setAccessible(true);
        fieldIdTriangle.setInt(TriangleRepository.class, 0);

        System.out.println();

    }


    @Test(priority = 1)
    public void testGetById() {

        Triangle actualTriangle = Triangle.createByPoints(new Point(-2, 4), new Point(-1, 7), new Point(3, 1));
        Triangle expectedTriangle = repository.getById(9).get();
        assertEquals(actualTriangle, expectedTriangle);

    }

    @Test(priority = 1)
    public void testGetActionById() {

        Triangle actualTriangle = Triangle.createByPoints(new Point(-2, 4), new Point(-1, 7), new Point(3, 1));
        TriangleAction actualAction = new TriangleAction(actualTriangle);

        Optional<TriangleAction> expectedAction = repository.getActionById(9);
        assertEquals(actualAction, expectedAction.get());

    }

}
