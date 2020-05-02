package by.mishota.composite.reader;

import by.mishota.composite.exception.ReadingException;
import by.mishota.composite.reader.impl.TextReaderFile;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TextComponentReaderFileTest {
    TextReader textReader;

    @Test
    public void testGetReading() throws ReadingException {
        Path pathToTestFile = Path.of("src/test/java/resources/parsingText.txt");
        textReader = new TextReaderFile();
        int actualNumber = 2575;
        String line = textReader.read(pathToTestFile);

        assertEquals(actualNumber, line.length());
    }

    @Test(expectedExceptions = ReadingException.class)
    public void testGetThrowException() throws ReadingException {
        Path pathToTestFile = Path.of("src/test/java/resources/throw.txt");
        textReader = new TextReaderFile();
        textReader.read(pathToTestFile);

        fail();
    }
}
