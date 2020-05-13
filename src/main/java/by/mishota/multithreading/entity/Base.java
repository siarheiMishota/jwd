package by.mishota.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private static Base instance;
    private static Logger logger = LogManager.getLogger();

    private List<Terminal> terminals=new ArrayList<>();
    private Territory territory;
    private Lock baseLock = new ReentrantLock();
    private Condition condition = baseLock.newCondition();

    private Base() {
        territory = new Territory();
    }

    public static Base getInstance() {
        Lock lockInstance = new ReentrantLock();
        if (instance == null) {
            try {
                lockInstance.lock();
                if (instance == null) {
                    instance = new Base();
                }
            } finally {
                lockInstance.unlock();
            }

        }
        return instance;
    }

    public void addTerminal(Terminal terminal){
        terminals.add(terminal);
    }

    public Terminal getTerminal(Cargo cargo) throws InterruptedException {

        territory.add(cargo);
        return null;
    }

    public void releaseTerminal() {

    }


}
