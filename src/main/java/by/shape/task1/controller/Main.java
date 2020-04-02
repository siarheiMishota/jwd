package by.shape.task1.controller;

import by.shape.task1.dao.TriangleDAOFile;
import by.shape.task1.exception.ServiceIoException;
import by.shape.task1.dao.TriangleDAO;
import by.shape.task1.service.TrianglesService;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        Path path = Path.of("src/main/resources/triangles.txt");
        TriangleDAO triangleDAO = new TriangleDAOFile(path);
        TrianglesService trianglesService = new TrianglesService(triangleDAO);

            try {
                trianglesService.getTrianglesFromDao();
                System.out.println(trianglesService.getTriangles());
            } catch (ServiceIoException e) {
                System.out.println("ERRROROROR");
            }
    }
}
