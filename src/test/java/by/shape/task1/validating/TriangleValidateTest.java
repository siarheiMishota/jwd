package by.shape.task1.validating;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TriangleValidateTest {

    TriangleValidate triangleValidate = new TriangleValidate();


    @Test
    public void testValidateLine() {

        String innerLine = " 1 1 5 5 10 10";
        assertTrue(triangleValidate.validateLine(innerLine));

    }

    @Test
    public void testValidateLineWithIncorrectNumbers() {

        String innerLine = " 1 1 5 5 10 10 10";
        assertFalse(triangleValidate.validateLine(innerLine));

    }

    @Test
    public void testValidateLineWithExtraSpaces() {

        String innerLine = "   1 1 5   5 10   10     ";
        assertTrue(triangleValidate.validateLine(innerLine));

    }


    @Test
    public void testValidateLineWithLetters() {

        String innerLine = "1 1 5 5 10 10w";
        assertFalse(triangleValidate.validateLine(innerLine));

    }

    @Test
    public void testValidatePointsBelongToSingleLine() {
        String innerLine = "1 1 2 2 5 5";
        assertTrue(triangleValidate.validateLine(innerLine));
    }


    @Test
    public void testValidatePointsNotBelongToSingleLine() {
        String innerLine = "1 1 2 2 8 5";
        assertTrue(triangleValidate.validateLine(innerLine));
    }
}
