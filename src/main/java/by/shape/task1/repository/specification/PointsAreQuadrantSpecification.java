package by.shape.task1.repository.specification;

import by.shape.task1.entity.Triangle;

public class PointsAreQuadrantSpecification implements Specification {

    private int numberOfQuadrant;

    public PointsAreQuadrantSpecification(int numberOfQuadrant) {
        this.numberOfQuadrant = numberOfQuadrant;
    }

    @Override
    public boolean test(Triangle triangle) {
        boolean belongingToQuadrantPointA, belongingToQuadrantPointB, belongingToQuadrantPointC;


        switch (numberOfQuadrant) {
            case 1:

                belongingToQuadrantPointA = triangle.getPointA().getX() > 0 && triangle.getPointA().getY() > 0;
                belongingToQuadrantPointB = triangle.getPointB().getX() > 0 && triangle.getPointB().getY() > 0;
                belongingToQuadrantPointC = triangle.getPointC().getX() > 0 && triangle.getPointC().getY() > 0;
                break;

            case 2:

                belongingToQuadrantPointA = triangle.getPointA().getX() < 0 && triangle.getPointA().getY() > 0;
                belongingToQuadrantPointB = triangle.getPointB().getX() < 0 && triangle.getPointB().getY() > 0;
                belongingToQuadrantPointC = triangle.getPointC().getX() < 0 && triangle.getPointC().getY() > 0;
                break;

            case 3:

                belongingToQuadrantPointA = triangle.getPointA().getX() < 0 && triangle.getPointA().getY() < 0;
                belongingToQuadrantPointB = triangle.getPointB().getX() < 0 && triangle.getPointB().getY() < 0;
                belongingToQuadrantPointC = triangle.getPointC().getX() < 0 && triangle.getPointC().getY() < 0;
                break;

            default:
                belongingToQuadrantPointA = triangle.getPointA().getX() > 0 && triangle.getPointA().getY() < 0;
                belongingToQuadrantPointB = triangle.getPointB().getX() > 0 && triangle.getPointB().getY() < 0;
                belongingToQuadrantPointC = triangle.getPointC().getX() > 0 && triangle.getPointC().getY() < 0;
        }

        return belongingToQuadrantPointA && belongingToQuadrantPointB && belongingToQuadrantPointC;

    }
}
