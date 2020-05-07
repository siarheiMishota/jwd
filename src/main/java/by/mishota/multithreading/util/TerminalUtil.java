package by.mishota.multithreading.util;

public class TerminalUtil {

    private static int GENERATE_ID=0;

    public static int getId() {
        return GENERATE_ID++;
    }
}
