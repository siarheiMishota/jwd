package by.mishotaa.composite.reader;

import by.mishotaa.composite.exception.ReadingException;

import java.nio.file.Path;

public interface TextReader {
    String read(Path path) throws ReadingException;
}
