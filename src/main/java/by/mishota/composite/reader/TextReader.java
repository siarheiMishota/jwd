package by.mishota.composite.reader;

import by.mishota.composite.exception.ReadingException;

import java.nio.file.Path;

public interface TextReader {
    String read(Path path) throws ReadingException;
}
