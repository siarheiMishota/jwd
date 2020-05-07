package by.mishota.multithreading.entity;

import by.mishota.multithreading.util.TerminalUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class Terminal implements Runnable {

    private static Logger logger = LogManager.getLogger();

    private int id;
    private Territory territory;

    public Terminal(Territory territory) {
        this.territory = territory;
        id = TerminalUtil.getId();
    }

    public int getId() {
        return id;
    }

    @Override
    public void run() {
        Cargo getting;

        while (true) {
            try {
                getting = territory.get();
                TimeUnit.SECONDS.sleep(getting.getType().takesSpace);
            } catch (InterruptedException e) {
                logger.warn("Getting a Car from the territory was interrupted");

            }
        }
    }
}
