package by.mishotaSiarhei.composite.reading;

import by.mishotaSiarhei.composite.exception.ReadingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TextReadingFileTest {

    TextReading textReading;
    static Logger logger = LogManager.getLogger();


    @Test
    public void testGetReading() throws ReadingException {

        Path pathToTestFile = Path.of("src/test/java/resources/parsingText.txt");
        textReading = new TextReadingFile(pathToTestFile);

        int actualNumber = 2575;
        String line = textReading.get();

        assertEquals(actualNumber, line.length());

    }

    @Test(expectedExceptions = ReadingException.class)
    public void testGetThrowException() throws ReadingException {

        Path pathToTestFile = Path.of("src/test/java/resources/throw.txt");
        textReading = new TextReadingFile(pathToTestFile);

        textReading.get();

        fail();
    }
}
