package by.mishota.multithreading.reader;


import by.mishota.multithreading.exception.ReadingException;

import java.nio.file.Path;
import java.util.List;

public interface CargoReader {
    List<String> read(Path path) throws ReadingException;

}
