package by.shape.task1.repository;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.ReadingException;
import by.shape.task1.exception.TriangleRepositoryException;
import by.shape.task1.reading.TriangleReading;
import by.shape.task1.reading.TriangleReadingFile;
import by.shape.task1.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {

    static Logger logger = LogManager.getLogger();

    private static TriangleRepository triangleRepository;
    private List<Triangle> triangles = new ArrayList<>();
    private Warehouse warehouse = Warehouse.getInstance();


    public static TriangleRepository getInstance(TriangleReading triangleReading) throws TriangleRepositoryException {

        if (triangleRepository == null) {

            triangleRepository = new TriangleRepository(triangleReading);
        }

        return triangleRepository;

    }


    private TriangleRepository(TriangleReading triangleReading) throws TriangleRepositoryException {

        try {

            List<Triangle> readingTriangles = triangleReading.getTriangles();
            triangles.addAll(readingTriangles);

            for (Triangle triangle : triangles) {

                TriangleAction action = new TriangleAction(triangle);
                warehouse.add(triangle.getId(), action);

            }


        } catch (ReadingException e) {

            logger.error("Triangle reading isn't correct");
            throw new TriangleRepositoryException("Triangle reading isn't correct", e);
        }
    }

    public boolean add(Triangle triangle) {


        TriangleAction action = new TriangleAction(triangle);
        warehouse.add(triangle.getId(), action);

        return triangles.add(triangle);
    }


    public boolean remove(Triangle triangle) {
        warehouse.remove(triangle.getId());
        return triangles.remove(triangle);
    }

    public List<Triangle> query(Specification specification) {

        return triangles.stream().filter(specification).collect(Collectors.toList());

    }

    public void sortId() {
        triangles.sort(Comparator.comparing(Triangle::getId));
    }

    public void sortByCoordinateXFirstPoint() {
        triangles.sort(Comparator.comparing(triangle -> triangle.getPointA().getX()));
    }

    public void sortByCoordinateYFirstPoint() {
        triangles.sort(Comparator.comparing(triangle -> triangle.getPointA().getY()));
    }

    public void sortByCoordinateXTwoPoint() {
        triangles.sort(Comparator.comparing(triangle -> triangle.getPointB().getX()));
    }

    public void sortByCoordinateYTwoPoint() {
        triangles.sort(Comparator.comparing(triangle -> triangle.getPointB().getY()));
    }


}
