package by.shape.task1.repository.specification;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;

import java.util.Optional;

public class PerimeterBetweenValuesSpecification implements Specification {

    private double startingValue, endingValue;

    public PerimeterBetweenValuesSpecification(double startingValue, double endingValue) {
        this.startingValue = startingValue;
        this.endingValue = endingValue;
    }

    @Override
    public boolean test(Triangle triangle) {

        Warehouse warehouse = Warehouse.getInstance();

        Optional<TriangleAction> action = warehouse.getById(triangle.getId());

        if (action.isPresent()) {

            double trianglePerimeter = action.get().getPerimeter();

            return startingValue <= trianglePerimeter && trianglePerimeter < endingValue;
        }

        return false;
    }
}
