package by.mishota.multithreading.util;

public class CargoUtil {

    private static int GENERATE_ID=0;

    public static int getGenerateId() {
        return GENERATE_ID++;
    }
}
