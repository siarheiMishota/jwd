package by.mishota.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Base {

    private static Base instance;
    private static Logger logger = LogManager.getLogger();

    private List<Terminal> terminals = new ArrayList<>();
    private Territory territory;
    private Lock locker = new ReentrantLock();
    private Condition baseCondition = locker.newCondition();

    private Base() {
        territory = new Territory(locker);
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

    public void addTerminal(Terminal terminal) {
        terminals.add(terminal);

    }

    public Terminal getTerminal(Cargo cargo) throws InterruptedException {
        Terminal terminal;
        territory.add(cargo);

        try {
            locker.lock();

            while (true) {
                Cargo head = territory.getHead();

                if (head.equals(cargo)) {
                    Optional<Terminal> optional = terminals.stream().filter(o -> !o.isWorking()).findAny();

                    while (optional.isEmpty()) {
                        baseCondition.await();
                        optional = terminals.stream().filter(o -> !o.isWorking()).findAny();
                    }

                    terminal = optional.get();
                    terminal.setWorking(true);
                    territory.get();
                    break;

                } else {
                    baseCondition.await();
                }
            }
        } finally {
            locker.unlock();
        }
        return terminal;
    }

    public void releaseTerminal() {
        try {
            locker.lock();
            baseCondition.signalAll();
        } finally {
            locker.unlock();
        }
    }
}
