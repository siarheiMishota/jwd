package by.shape.task1.repository.specification;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;

import java.util.Optional;

public class AreaBetweenValuesSpecification implements Specification {

    private double startingValue, endingValue;

    public AreaBetweenValuesSpecification(double startingValue, double endingValueInclude) {
        this.startingValue = startingValue;
        this.endingValue = endingValueInclude;
    }

    @Override
    public boolean test(Triangle triangle) {
        double accuracy = 0.0000001;

        Warehouse warehouse = Warehouse.getInstance();

        Optional<TriangleAction> action = warehouse.getById(triangle.getId());

        if (action.isPresent()) {
            double triangleArea = action.get().getArea();

            return triangleArea - startingValue >= -accuracy && endingValue - triangleArea >= -accuracy;
        }

        return false;
    }
}
