package by.shape.task1.repository.specification;

import by.shape.task1.entity.Point;
import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.TriangleRepositoryException;
import by.shape.task1.reading.TriangleReading;
import by.shape.task1.reading.TriangleReadingFile;
import by.shape.task1.repository.TriangleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TriangleSpecificationTest {


    Path path = Path.of("src/test/java/resources/test.txt");
    static Logger logger = LogManager.getLogger();

    TriangleReading triangleReading = new TriangleReadingFile(path);
    TriangleRepository repository;

    @BeforeMethod
    public void setUp() throws TriangleRepositoryException {
        repository = TriangleRepository.getInstance(triangleReading);


    }

    @Test
    public void testIdSpecification() {

        Triangle triangle = Triangle.createByPoints(new Point(-2, 4), new Point(-1, 7), new Point(3, 1));

        Specification specification = new IdSpecification(9);
        List<Triangle> queryTriangle = repository.query(specification);
        assertEquals(triangle, queryTriangle.get(0));
    }

    @Test
    public void testAreaBetweenValuesSpecification() {

        Specification specification = new AreaBetweenValuesSpecification(5, 8);
        List<Triangle> queryTriangle = repository.query(specification);

        int countOfEntriesOfList = 5;

        assertEquals(countOfEntriesOfList, queryTriangle.size());
    }

    @Test
    public void testAreaLessNumberSpecification() {

        Specification specification = new AreaLessNumberSpecification(6);
        List<Triangle> queryTriangle = repository.query(specification);

        int countOfEntriesOfList = 5;

        assertEquals(countOfEntriesOfList, queryTriangle.size());
    }

    @Test
    public void testAreaMoreNumberSpecification() {

        Specification specification = new AreaMoreNumberSpecification(6);
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList = 8;

        assertEquals(countOfEntriesOfList, queryTriangles.size());
    }

    @Test
    public void testIsAcuteAngleSpecification() {

        Specification specification = new IsAcuteSpecification();
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList = 5;

        assertEquals(countOfEntriesOfList, queryTriangles.size());
    }

    @Test
    public void testIsEquilateralSpecification() {

        Specification specification = new IsEquilateralSpecification();
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList = 0;

        assertEquals(countOfEntriesOfList, queryTriangles.size());
    }

    @Test
    public void testIsIsoscelesSpecification() {

        Specification specification = new IsIsoscelesSpecification();
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList = 2;

        assertEquals(countOfEntriesOfList, queryTriangles.size());
    }

    @Test
    public void testIsObtuseSpecification() {

        Specification specification = new IsObtuseSpecification();
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=4;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testIsRightSpecification() {

        Specification specification = new IsRightSpecification();
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=1;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testNotSpecification() {

        Specification specification = new NotSpecification();
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=10;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testPerimeterBetweenValuesSpecification() {

        Specification specification = new PerimeterBetweenValuesSpecification(10,15);
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=5;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testPerimeterLessNumberSpecification() {

        Specification specification = new PerimeterLessNumberSpecification(13);
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=2;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testPerimeterMoreNumberSpecification() {

        Specification specification = new PerimeterMoreNumberSpecification(13);
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=8;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testPointAreFirstQuadrantSpecification() {

        Specification specification = new PointsAreQuadrantSpecification(1);
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=1;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testPointAreTwoQuadrantSpecification() {

        Specification specification = new PointsAreQuadrantSpecification(2);
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=1;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testPointAreThreeQuadrantSpecification() {

        Specification specification = new PointsAreQuadrantSpecification(3);
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=0;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }

    @Test
    public void testPointAreFourQuadrantSpecification() {

        Specification specification = new PointsAreQuadrantSpecification(4);
        List<Triangle> queryTriangles = repository.query(specification);

        int countOfEntriesOfList=1;

        assertEquals(countOfEntriesOfList,queryTriangles.size());
    }
}
