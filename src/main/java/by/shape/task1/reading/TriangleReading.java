package by.shape.task1.reading;

import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.ReadingException;

import java.util.List;

public interface TriangleReading {

    List<Triangle> getTriangles() throws ReadingException;

}
