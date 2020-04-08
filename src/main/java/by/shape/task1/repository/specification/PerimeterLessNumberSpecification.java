package by.shape.task1.repository.specification;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;

public class PerimeterLessNumberSpecification implements Specification {

    private double number;

    public PerimeterLessNumberSpecification(double endValue) {
        this.number = endValue;
    }

    @Override
    public boolean test(Triangle triangle) {

        Warehouse warehouse = Warehouse.getInstance();

        TriangleAction action = warehouse.getById(triangle.getId());

        if (action == null) {
            return false;
        }
        double trianglePerimeter = action.getPerimeter();

        return number > trianglePerimeter;
    }
}
