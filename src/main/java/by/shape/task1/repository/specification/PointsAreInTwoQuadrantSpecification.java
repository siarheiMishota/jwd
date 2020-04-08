package by.shape.task1.repository.specification;

import by.shape.task1.entity.Triangle;

public class PointsAreInTwoQuadrantSpecification implements Specification {

    @Override
    public boolean test(Triangle triangle) {
        boolean belongingToQuadrantPointA = triangle.getPointA().getX() < 0 && triangle.getPointA().getY() > 0;
        boolean belongingToQuadrantPointB = triangle.getPointB().getX() < 0 && triangle.getPointB().getY() > 0;
        boolean belongingToQuadrantPointC = triangle.getPointC().getX() < 0 && triangle.getPointC().getY() > 0;

        return belongingToQuadrantPointA && belongingToQuadrantPointB && belongingToQuadrantPointC;
    }
}
