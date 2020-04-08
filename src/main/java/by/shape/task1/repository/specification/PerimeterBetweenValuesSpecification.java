package by.shape.task1.repository.specification;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;

public class PerimeterBetweenValuesSpecification implements Specification {

    private double startingValue, endingValue;

    public PerimeterBetweenValuesSpecification(double startingValue, double endingValue) {
        this.startingValue = startingValue;
        this.endingValue = endingValue;
    }

    @Override
    public boolean test(Triangle triangle) {

        Warehouse warehouse = Warehouse.getInstance();

        TriangleAction action = warehouse.getById(triangle.getId());

        if (action == null) {
            return false;
        }

        double trianglePerimeter = action.getPerimeter();

        return startingValue <= trianglePerimeter && trianglePerimeter < endingValue;
    }
}
