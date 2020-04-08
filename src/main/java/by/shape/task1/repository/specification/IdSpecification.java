package by.shape.task1.repository.specification;

import by.shape.task1.entity.Triangle;

public class IdSpecification implements Specification {

    private long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean test(Triangle  triangle) {
        return id==triangle.getId();
    }
}
