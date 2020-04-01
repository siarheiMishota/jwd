package shape.task1.validate;

import org.testng.Assert;
import org.testng.annotations.Test;
import shape.task1.exception.TriangleValidateException;

public class TriangleValidateTest {

    TriangleValidate triangleValidate = new TriangleValidate();

    @Test
    public void testCorrectValidate() {

        String innerLine = "10 1 1 5 5 10 0";
        triangleValidate.validate(innerLine);
    }

    @Test(expectedExceptions = TriangleValidateException.class,expectedExceptionsMessageRegExp = "All point belong to single line")
    public void testValidateIncorrectPointsBelongLine() {

        String innerLine = "10 1 1 5 5 10 10";
        triangleValidate.validate(innerLine);
    }

    @Test
    public void  testValidateCorrectNumberOfElements(){
        String innerLine = "20 12 1 53 5 10 10";
        triangleValidate.validate(innerLine);
    }

    @Test(expectedExceptions = TriangleValidateException.class,expectedExceptionsMessageRegExp = "Incorrect length of line.")
    public void  testValidateNumberOfElementsLessThenNeed(){
        String innerLine = "20 12 1 53 5 10";
        triangleValidate.validate(innerLine);
    }

    @Test(expectedExceptions = TriangleValidateException.class,expectedExceptionsMessageRegExp = "Incorrect length of line.")
    public void  testValidateNumberOfElementsMoreThenNeed(){
        String innerLine = "20 12 1 53 5 10 12 15 16 14";
        triangleValidate.validate(innerLine);
    }

    @Test(expectedExceptions = TriangleValidateException.class,expectedExceptionsMessageRegExp = "Incorrect point value.")
    public void  testValidateIncorrectParserElements(){
        String innerLine = "20 1a2 1 53 5 10 51";
        triangleValidate.validate(innerLine);
    }

    @Test(expectedExceptions = TriangleValidateException.class,expectedExceptionsMessageRegExp = "Incorrect point value.")
    public void  testValidateIncorrectParserElementsElse(){
        String innerLine = "20 12 1 532w4f 5 10 51";
        triangleValidate.validate(innerLine);
    }

    @Test()
    public void  testValidateCorrectParserElements(){
        String innerLine = "20 12 1 53 5 10 51";
        triangleValidate.validate(innerLine);
    }
}
