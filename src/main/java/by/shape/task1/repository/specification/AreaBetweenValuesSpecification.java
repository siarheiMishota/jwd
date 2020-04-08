package by.shape.task1.repository.specification;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;

public class AreaBetweenValuesSpecification implements Specification {

    private double startingValue, endingValue;

    public AreaBetweenValuesSpecification(double startingValue, double endingValue) {
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

        double triangleArea = action.getArea();

        return startingValue <= triangleArea && triangleArea < endingValue;
    }
}
