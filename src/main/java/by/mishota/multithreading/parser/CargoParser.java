package by.mishota.multithreading.parser;

public class CargoParser {

    private static final String PATTERN_ELEMENTS = " ";

    public static String[] parse(String line) {

        return line.split(PATTERN_ELEMENTS);

    }
}
