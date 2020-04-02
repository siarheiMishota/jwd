package by.shape.task1.dao;

import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.DaoIOException;

import java.util.List;

public interface TriangleDAO {

    List<Triangle> getTriangles() throws DaoIOException;
    void saveTriangles(List<Triangle> triangles) throws DaoIOException;

}
