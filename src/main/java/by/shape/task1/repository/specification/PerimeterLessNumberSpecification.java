package by.shape.task1.repository.specification;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;

import java.util.Optional;

public class PerimeterLessNumberSpecification implements Specification {

    private double number;

    public PerimeterLessNumberSpecification(double endValue) {
        this.number = endValue;
    }

    @Override
    public boolean test(Triangle triangle) {

        Warehouse warehouse = Warehouse.getInstance();

        Optional<TriangleAction> action = warehouse.getById(triangle.getId());

        if (action.isPresent()) {
            double trianglePerimeter = action.get().getPerimeter();

            return number > trianglePerimeter;
        }

        return false;
    }
}
