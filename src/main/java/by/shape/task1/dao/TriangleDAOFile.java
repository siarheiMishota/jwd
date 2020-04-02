package by.shape.task1.dao;

import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.DaoIOException;
import by.shape.task1.validating.TriangleParser;
import by.shape.task1.validating.TriangleValidate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TriangleDAOFile implements TriangleDAO {

    private Path path;

    public TriangleDAOFile(Path path) {
        this.path = path;
    }

    @Override
    public List<Triangle> getTriangles() throws DaoIOException {

        List<String> lines = getLines();
        List<Triangle> triangles = new ArrayList<>();

        TriangleValidate triangleValidate = new TriangleValidate();
        TriangleParser triangleParser=new TriangleParser(triangleValidate);
        Triangle triangle;
        for (String line : lines) {

            if ((triangle=triangleParser.parsing(line))!=null){
                triangles.add(triangle);
            }


        }
        return triangles;
    }

    private List<String> getLines() throws DaoIOException {
        List<String> lines;

        try {
            lines = Files.readAllLines(path);

        } catch (IOException e) {
            throw new DaoIOException("File doesn't exist", e);
        }

        return lines;

    }

    @Override
    public void saveTriangles(List<Triangle> triangles) throws DaoIOException {

        List<String> linesForSave = new ArrayList<>();

        for (Triangle triangle : triangles) {

            linesForSave.add(String.valueOf(triangle.getId()));
            linesForSave.add(" ");
            linesForSave.add(String.valueOf(triangle.getPointA().getX()));
            linesForSave.add(" ");
            linesForSave.add(String.valueOf(triangle.getPointA().getY()));
            linesForSave.add(" ");
            linesForSave.add(String.valueOf(triangle.getPointB().getX()));
            linesForSave.add(" ");
            linesForSave.add(String.valueOf(triangle.getPointB().getY()));
            linesForSave.add(" ");
            linesForSave.add(String.valueOf(triangle.getPointC().getX()));
            linesForSave.add(" ");
            linesForSave.add(String.valueOf(triangle.getPointC().getY()));
            linesForSave.add("\n");
        }

        try {
            Files.write(path, linesForSave);
        } catch (IOException e) {
            throw new DaoIOException("Error while saving file", e);
        }

    }
}
