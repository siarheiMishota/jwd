package by.mishota.multithreading.entity;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Territory {

    private Queue<Cargo> queue = new PriorityQueue<>(Comparator.comparing(Cargo::isPerishable).reversed());
    private static final int CAPACITY_AREA =40;
    private int occupyingArea = 0;

    private Lock locker;
    private Condition condition;

    public Territory() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }


    public Cargo get() throws InterruptedException {
        Cargo getting;
        locker.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            getting = queue.poll();
            occupyingArea-=getting.getType().getTakesSpace();
            condition.signalAll();

        } finally {
            locker.unlock();
        }
        return getting;
    }

    public void add(Cargo putting) throws InterruptedException {

        locker.lock();
        try {
            while (occupyingArea+putting.getType().getTakesSpace()> CAPACITY_AREA)
                condition.await();

            queue.add(putting);
            occupyingArea+=putting.getType().getTakesSpace();
            condition.signalAll();
        } finally {
            locker.unlock();
        }
    }
}



