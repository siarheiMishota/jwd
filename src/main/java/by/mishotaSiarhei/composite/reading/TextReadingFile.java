package by.mishotaSiarhei.composite.reading;

import by.mishotaSiarhei.composite.exception.ReadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReadingFile implements TextReading {

    private Path path;

    public TextReadingFile(Path path) {
        this.path = path;
    }

    @Override
    public String get() throws ReadingException {
        String text;

        try {
            text = Files.readString(path);
        } catch (IOException e) {
            throw new ReadingException("File doesn't found", e);
        }

        return text;
    }


}
