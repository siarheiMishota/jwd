package by.shape.task1.reading;

import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.ReadingException;
import by.shape.task1.validating.TriangleParser;
import by.shape.task1.validating.TriangleValidate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TriangleReadingFile implements TriangleReading {

    private static Logger logger = LogManager.getLogger();
    private Path path;

    public TriangleReadingFile(Path path) {
        this.path = path;
    }

    @Override
    public List<Triangle> getTriangles() throws ReadingException {

        List<String> lines = getLines();
        List<Triangle> triangles = new ArrayList<>();

        TriangleValidate triangleValidate = new TriangleValidate();
        TriangleParser triangleParser = new TriangleParser(triangleValidate);
        Triangle triangle;
        for (String line : lines) {


            if ((triangle = triangleParser.parsing(line.trim())) != null) {
                triangles.add(triangle);
            }


        }
        return triangles;
    }

    private List<String> getLines() throws ReadingException {
        List<String> lines;

        try {
            lines = Files.readAllLines(path);

        } catch (IOException e) {

            logger.error("File isn't find for reading: " + path);
            throw new ReadingException("File doesn't exist", e);
        }

        return lines;

    }

}
