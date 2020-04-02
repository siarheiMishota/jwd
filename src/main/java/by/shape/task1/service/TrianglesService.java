package by.shape.task1.service;

import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.DaoIOException;
import by.shape.task1.exception.ServiceIoException;
import by.shape.task1.dao.TriangleDAO;

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
