package by.shape.task1.repository.specification;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.action.Warehouse;
import by.shape.task1.entity.Triangle;

import java.util.Optional;

public class AreaMoreNumberSpecification implements Specification {

    private double number;

    public AreaMoreNumberSpecification(double startValue) {
        this.number = startValue;
    }

    @Override
    public boolean test(Triangle triangle) {

        double accuracy = 0.0000001;

        Warehouse warehouse = Warehouse.getInstance();

        Optional<TriangleAction> action = warehouse.getById(triangle.getId());

        if (action.isPresent()) {

            double area=action.get().getArea();
            boolean asda=number-area<=accuracy;
            return asda;
//            return number - action.get().getArea() <=accuracy;
        }

        return false;


    }
}
