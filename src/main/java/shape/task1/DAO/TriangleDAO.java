package shape.task1.DAO;

import shape.task1.entity.Triangle;

import java.util.List;

public interface TriangleDAO {

    List<Triangle> getTriangles();
    void saveTriangles(List<Triangle> triangles);

}
