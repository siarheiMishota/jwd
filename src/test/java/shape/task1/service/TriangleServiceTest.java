package shape.task1.service;

import org.testng.annotations.Test;
import shape.task1.entity.Point;
import shape.task1.entity.Triangle;

import static org.testng.Assert.*;

public class TriangleServiceTest {

    @Test
    public void testAreaCorrect() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 0);
        Point pointC = new Point(0, 4);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertEquals(triangleService.area(), 6, 0.0001);
    }

    @Test
    public void testAreaCorrectTwo() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(100, 0);
        Point pointC = new Point(0, -50);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertEquals(triangleService.area(), 2500, 0.0001);
    }

    @Test
    public void testPerimeter() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 0);
        Point pointC = new Point(0, 4);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertEquals(triangleService.perimeter(), 12, 0.0001);
    }

    @Test
    public void testIsRight() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(3, 0);
        Point pointC = new Point(0, 4);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertTrue(triangleService.isRight());

    }

    @Test
    public void testIsNotRight() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(1, 0);
        Point pointC = new Point(10, 4);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertFalse(triangleService.isRight());

    }

    @Test
    public void testIsIsosceles() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(10, 0);
        Point pointC = new Point(0, 10);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertTrue(triangleService.isIsosceles());
    }

    @Test
    public void testIsIsoscelesTwo() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(5, 5);
        Point pointC = new Point(0, 10);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertTrue(triangleService.isIsosceles());
    }

    @Test
    public void testIsNotIsosceles() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(10, 3);
        Point pointC = new Point(123, 10);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertFalse(triangleService.isIsosceles());
    }

    @Test
    public void testIsEquilateral() {

        int id = 10;
        Point pointA = new Point(2, -3);
        Point pointB = new Point(-2, 3);
        Point pointC = new Point(-3*Math.sqrt(3), -2*Math.sqrt(3));
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertTrue(triangleService.isEquilateral());

    }

    @Test
    public void testIsEquilateralTwo() {

        int id = 10;
        Point pointA = new Point(2, -3);
        Point pointB = new Point(-2, 3);
        Point pointC = new Point(3*Math.sqrt(3), 2*Math.sqrt(3));
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertTrue(triangleService.isEquilateral());

    }

    @Test
    public void testIsNotEquilateral() {

        int id = 10;
        Point pointA = new Point(4, -8);
        Point pointB = new Point(-9, 9);
        Point pointC = new Point(5, -7);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertFalse(triangleService.isEquilateral());

    }

    @Test
    public void testIsNotEquilateralTwo() {

        int id = 10;
        Point pointA = new Point(2, 2);
        Point pointB = new Point(6, 5);
        Point pointC = new Point(-2, 4);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertFalse(triangleService.isEquilateral());

    }

    @Test
    public void testIsAcuteAngle() {

        int id = 10;
        Point pointA = new Point(0, 0);
        Point pointB = new Point(2, 5);
        Point pointC = new Point(5, 1);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertTrue(triangleService.isAcuteAngle());
    }

    @Test
    public void testIsAcuteAngleTwo() {

        int id = 10;
        Point pointA = new Point(10, -15);
        Point pointB = new Point(21, 5);
        Point pointC = new Point(5, 1);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertTrue(triangleService.isAcuteAngle());
    }

    @Test
    public void testIsNotAcuteAngleTwo() {

        int id = 10;
        Point pointA = new Point(1, -15);
        Point pointB = new Point(21, 5);
        Point pointC = new Point(5, 1);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertFalse(triangleService.isAcuteAngle());
    }

    @Test
    public void testIsObtuseAngle() {

        int id = 10;
        Point pointA = new Point(1, -15);
        Point pointB = new Point(21, 5);
        Point pointC = new Point(5, 1);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertTrue(triangleService.isObtuseAngle());
    }

    @Test
    public void testIsNotObtuseAngle() {

        int id = 10;
        Point pointA = new Point(11, -15);
        Point pointB = new Point(2, 5);
        Point pointC = new Point(25, 1);
        Triangle triangle = new Triangle(id, pointA, pointB, pointC);

        TriangleService triangleService = new TriangleService(triangle);

        assertFalse(triangleService.isObtuseAngle());
    }

    @Test
    public void testSide() {

        Point pointA = new Point(11, 5);
        Point pointB = new Point(2, 5);
        double actual=TriangleService.side(pointA,pointB);
        double expected=9;
        assertEquals(actual,expected,0.0001);

    }

    @Test
    public void testSideTwo() {

        Point pointA = new Point(11, -15);
        Point pointB = new Point(2, 5);
        double actual=TriangleService.side(pointA,pointB);
        double expected=21.931712199461;
        assertEquals(actual,expected,0.0001);

    }
}
