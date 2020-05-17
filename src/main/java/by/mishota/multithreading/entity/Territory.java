package by.mishota.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Territory {

    private static Logger logger = LogManager.getLogger();

    private Queue<Cargo> queue = new PriorityQueue<>(Comparator.comparing(Cargo::isPerishable).reversed());
    private static final int CAPACITY_AREA = 40;
    private int occupyingArea = 0;

    private Lock locker;
    private Condition condition;

    public Cargo peekHead() {
        return queue.peek();
    }

    public Territory(Lock locker) {
        this.locker = locker;
        condition = locker.newCondition();
    }

    public Cargo poll() throws InterruptedException {
        Cargo getting;
        locker.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            getting = queue.poll();
            occupyingArea -= getting.getType().getTakesSpace();
            condition.signalAll();
        } finally {
            locker.unlock();
        }
        return getting;
    }

    public void add(Cargo putting) throws InterruptedException {

        locker.lock();
        try {
            while (occupyingArea + putting.getType().getTakesSpace() > CAPACITY_AREA)
                condition.await();

            queue.add(putting);
            logger.info(String.format("Car(%d) is added to queue", putting.getId()));
            occupyingArea += putting.getType().getTakesSpace();
            condition.signalAll();
        } finally {
            locker.unlock();
        }
    }
}



