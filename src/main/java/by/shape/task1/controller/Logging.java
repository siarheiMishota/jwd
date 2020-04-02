package by.shape.task1.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {

    // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
    private static final Logger logger = LogManager.getLogger();

    public static void main(final String... args) {


        for (int i = 0; i <10000 ; i++) {

            logger.error("error- "+i);

        }
    }



}
