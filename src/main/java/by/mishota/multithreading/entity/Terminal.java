package by.mishota.multithreading.entity;

import by.mishota.multithreading.exception.TerminalException;
import by.mishota.multithreading.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Terminal {

    private static Logger logger = LogManager.getLogger();
    private static Random random = new Random();

    private int id;
    private boolean working;

    public Terminal() {
        id = Util.getGenerateTerminalID();
    }

    public int getId() {
        return id;
    }

    public boolean isWorking() {
        return working;
    }

    public int load(Cargo cargo) {

        logger.info(String.format("The Cargo(%4d,%b) is being loaded at terminal(%4d)", cargo.getId(), cargo.isPerishable(), id));
        working = true;
        int timeLoading = makeRandomIntValue();

        try {
            TimeUnit.MILLISECONDS.sleep(timeLoading);
        } catch (InterruptedException e) {
            throw new TerminalException("The cargo wasn't loaded", e);
        } finally {
            working = false;
        }

        logger.info(String.format("The Cargo(%4d,%b) load was finished  at terminal(%4d)", cargo.getId(), cargo.isPerishable(), id));

        return timeLoading;
    }

    private static int makeRandomIntValue() {
        return random.nextInt(1000);
    }


}
