package shape.task1.DAO;

import shape.task1.entity.Triangle;
import shape.task1.exception.DaoIOException;

import java.util.List;

public interface TriangleDAO {

    List<Triangle> getTriangles() throws DaoIOException;
    void saveTriangles(List<Triangle> triangles) throws DaoIOException;

}
