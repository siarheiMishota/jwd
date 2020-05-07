package by.mishota.multithreading.reader.impl;

import by.mishota.multithreading.exception.ReadingException;
import by.mishota.multithreading.reader.CargoReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CargoReaderFile implements CargoReader {
    @Override
    public List<String> read(Path path) throws ReadingException {
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new ReadingException("File doesn't found", e);
        }
        return lines;
    }
}
