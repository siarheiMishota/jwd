package shape.task1.DAO;

import shape.task1.entity.Point;
import shape.task1.entity.Triangle;
import shape.task1.exception.DaoIOException;
import shape.task1.exception.TriangleValidateException;
import shape.task1.validate.TriangleValidate;

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

        for (String line : lines) {

            line = line.trim();

            try {

                triangleValidate.validate(line);


                String[] splittingLine = line.split(" ");

                int positionNumber = 0;

                int id = Integer.parseInt(splittingLine[positionNumber++]);
                double pointAX = Double.parseDouble(splittingLine[positionNumber++]);
                double pointAY = Double.parseDouble(splittingLine[positionNumber++]);
                double pointBX = Double.parseDouble(splittingLine[positionNumber++]);
                double pointBY = Double.parseDouble(splittingLine[positionNumber++]);
                double pointCX = Double.parseDouble(splittingLine[positionNumber++]);
                double pointCY = Double.parseDouble(splittingLine[positionNumber++]);

                Point pointA = new Point(pointAX, pointAY);
                Point pointB = new Point(pointBX, pointBY);
                Point pointC = new Point(pointCX, pointCY);

                Triangle triangle = new Triangle(id, pointA, pointB, pointC);

                triangles.add(triangle);

            } catch (TriangleValidateException e) {
//------------------------------------------------------------------------------------------------------------------------------
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
