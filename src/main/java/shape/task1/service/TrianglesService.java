package shape.task1.service;

import shape.task1.DAO.TriangleDAO;
import shape.task1.entity.Triangle;
import shape.task1.exception.DaoIOException;
import shape.task1.exception.ServiceIoException;

import java.util.ArrayList;
import java.util.List;

public class TrianglesService {

    private TriangleDAO triangleDAO;
    private List<Triangle> triangles = new ArrayList<>();

    public List<Triangle> getTriangles() {
        return triangles;
    }

    public TrianglesService(TriangleDAO triangleDAO, List<Triangle> triangles) {
        this.triangleDAO = triangleDAO;
        this.triangles.addAll(triangles);
    }

    public TrianglesService(TriangleDAO triangleDAO) {
        this.triangleDAO = triangleDAO;
    }

    public void getTrianglesFromDao() throws ServiceIoException {

        try {
            List<Triangle> gotTriangles = triangleDAO.getTriangles();
            triangles.addAll(gotTriangles);
        } catch (DaoIOException e) {
            throw new ServiceIoException("Incorrect file for reading", e);
        }

    }

    public void saveTrianglesToDao() throws ServiceIoException {

        try {
            triangleDAO.saveTriangles(triangles);
        } catch (DaoIOException e) {
            throw new ServiceIoException("Incorrect file for saving", e);
        }
    }
}
