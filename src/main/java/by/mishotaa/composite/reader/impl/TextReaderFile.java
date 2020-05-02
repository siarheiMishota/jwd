package by.mishotaa.composite.reader.impl;

import by.mishotaa.composite.reader.TextReader;
import by.mishotaa.composite.exception.ReadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReaderFile implements TextReader {

    @Override
    public String read(Path path) throws ReadingException {
        String text;

        try {
            text = Files.readString(path);
        } catch (IOException e) {
            throw new ReadingException("File doesn't found", e);
        }
        return text;
    }
}
