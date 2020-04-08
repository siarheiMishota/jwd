package by.shape.task1.service;

import by.shape.task1.action.TriangleAction;
import by.shape.task1.entity.Point;
import org.testng.annotations.Test;
import by.shape.task1.entity.Triangle;

import static org.testng.Assert.*;

public class TriangleActionTest {

    @Test
    public void testAreaCorrect() {

        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 0);
        Point pointC = new Point(0, 4);
        Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertEquals(triangleAction.getArea(), 6, 0.0001);
    }


    @Test
    public void testPerimeter() {

        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 0);
        Point pointC = new Point(0, 4);
        Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertEquals(triangleAction.getPerimeter(), 12, 0.0001);
    }

    @Test
    public void testIsRight() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 0);
        Point pointC = new Point(0, 4);
        Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertTrue(triangleAction.isRight());

    }

    @Test
    public void testIsNotRight() {

        Point pointA = new Point(0, 0);
        Point pointB = new Point(1, 0);
        Point pointC = new Point(10, 4);
        Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertFalse(triangleAction.isRight());

    }

    @Test
    public void testIsIsosceles() {

        Point pointA = new Point(0, 0);
        Point pointB = new Point(10, 0);
        Point pointC = new Point(0, 10);
        Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertTrue(triangleAction.isIsosceles());
    }


    @Test
    public void testIsNotIsosceles() {

        Point pointA = new Point(0, 0);
        Point pointB = new Point(10, 3);
        Point pointC = new Point(123, 10);
        Triangle triangle = Triangle.createByPoints(pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertFalse(triangleAction.isIsosceles());
    }

    @Test
    public void testIsEquilateral() {

        Point pointA = new Point(2, -3);
        Point pointB = new Point(-2, 3);
        Point pointC = new Point(-3*Math.sqrt(3), -2*Math.sqrt(3));
        Triangle triangle = Triangle.createByPoints(pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertTrue(triangleAction.isEquilateral());

    }


    @Test
    public void testIsNotEquilateral() {

        Point pointA = new Point(4, -8);
        Point pointB = new Point(-9, 9);
        Point pointC = new Point(5, -7);
        Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertFalse(triangleAction.isEquilateral());

    }



    @Test
    public void testIsAcuteAngle() {

        Point pointA = new Point(0, 0);
        Point pointB = new Point(2, 5);
        Point pointC = new Point(5, 1);
        Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertTrue(triangleAction.isAcuteAngle());
    }


    @Test
    public void testIsObtuseAngle() {

        Point pointA = new Point(1, -15);
        Point pointB = new Point(21, 5);
        Point pointC = new Point(5, 1);
        Triangle triangle = Triangle.createByPoints( pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertTrue(triangleAction.isObtuseAngle());
    }

    @Test
    public void testIsNotObtuseAngle() {

        Point pointA = new Point(11, -15);
        Point pointB = new Point(2, 5);
        Point pointC = new Point(25, 1);
        Triangle triangle = Triangle.createByPoints(pointA, pointB, pointC);

        TriangleAction triangleAction = new TriangleAction(triangle);

        assertFalse(triangleAction.isObtuseAngle());
    }

    @Test
    public void testSide() {

        Point pointA = new Point(11, 5);
        Point pointB = new Point(2, 5);
        double actual= TriangleAction.side(pointA,pointB);
        double expected=9;
        assertEquals(actual,expected,0.0001);

    }

}
