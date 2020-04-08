package by.shape.task1.controller;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.entity.Triangle;
import by.shape.task1.exception.TriangleRepositoryException;
import by.shape.task1.reading.TriangleReading;
import by.shape.task1.reading.TriangleReadingFile;
import by.shape.task1.repository.TriangleRepository;
import by.shape.task1.repository.specification.AreaLessNumberSpecification;
import by.shape.task1.repository.specification.IdSpecification;
import by.shape.task1.repository.specification.Specification;

import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path path = Path.of("src/main/resources/triangles.txt");
        TriangleReading triangleReading = new TriangleReadingFile(path);
        TriangleRepository repository ;

        int idTriangle=0;

        try {

            repository = TriangleRepository.getInstance(triangleReading);


            Specification specification=new AreaLessNumberSpecification(8);

            List<Triangle> query = repository.query(specification);

            System.out.println(query.size());

            for (Triangle triangle:query) {

                System.out.println(triangle+"- ");

            }

            System.out.println();


        } catch (TriangleRepositoryException e) {
            e.printStackTrace();
        }


    }
}
