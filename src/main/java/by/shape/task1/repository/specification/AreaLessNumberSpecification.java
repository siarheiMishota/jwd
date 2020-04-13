package by.shape.task1.repository.specification;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;

import java.util.Optional;

public class AreaLessNumberSpecification implements Specification {

    private double number;

    public AreaLessNumberSpecification(double endValue) {
        this.number = endValue;
    }

    @Override
    public boolean test(Triangle triangle) {

        double accuracy = 0.0000001;
        Warehouse warehouse = Warehouse.getInstance();

        Optional<TriangleAction> action = warehouse.getById(triangle.getId());

        if (action.isPresent()) {
            double triangleArea = action.get().getArea();

            return number - triangleArea > -accuracy;
        }

        return false;
    }
}
