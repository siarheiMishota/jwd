package shape.task1.DAO;

import shape.task1.entity.Triangle;
import shape.task1.exception.TriangleOpeningFileException;
import shape.task1.validate.TriangleValidate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TriangleDAOFile implements TriangleDAO {

    private Path path;

    public TriangleDAOFile(Path path) {
        this.path = path;
    }

    @Override
    public List<Triangle> getTriangles() {
        
        List<String> lines = getLines();

        TriangleValidate triangleValidate = new TriangleValidate();

        for (String line : lines) {

            line = line.trim();

            try {


                if (triangleValidate.validateParsing(line)) {


                }
            }


        }


        return;
    }

    private List<String> getLines() {
        List<String> lines;

        try {
            lines = Files.readAllLines(path);

        } catch (IOException e) {
            throw new TriangleOpeningFileException("File doesn't exist", e);
        }

        return lines

    }

    @Override
    public void saveTriangles(List<Triangle> triangles) {

    }
}
