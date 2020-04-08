package by.shape.task1.repository.specification;

import by.shape.task1.entity.Triangle;

public class NotSpecification   implements Specification {
    @Override
    public boolean test(Triangle triangle) {
        return true;
    }
}
