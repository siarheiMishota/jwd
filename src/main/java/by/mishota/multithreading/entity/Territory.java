package by.mishota.multithreading.entity;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Territory {

    private Queue<Cargo> queue = new PriorityQueue<>(Comparator.comparing(Cargo::isQuicklyPerishable).reversed());
    private int capacityArea, occupyingArea = 0;

    private Lock locker;
    private Condition condition;

    public Territory(int capacityArea) {
        this.capacityArea = capacityArea;
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
            occupyingArea-=getting.getType().takesSpace;
            condition.signalAll();

        } finally {
            locker.unlock();
        }
        return getting;
    }

    public void put(Cargo putting) throws InterruptedException {

        locker.lock();
        try {
            while (occupyingArea+putting.getType().takesSpace> capacityArea)
                condition.await();

            queue.add(putting);
            occupyingArea+=putting.getType().takesSpace;
            condition.signalAll();
        } finally {
            locker.unlock();
        }
    }
}



