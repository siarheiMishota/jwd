package by.mishota.multithreading.util;

public class Util {

    private static int generateCargoID =0;
    private static int generateTerminalID=0;

    public static int getGenerateCargoID() {
        return generateCargoID++;
    }

    public static int getGenerateTerminalID() {
        return generateTerminalID++;
    }
}
