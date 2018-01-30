package com.conklin;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DepositThread implements Runnable {
    int rndDeposit = 0;
    private static Random randomGenerator = new Random();
    private Lock accessLock = new ReentrantLock();

    public int deposit() {
        rndDeposit = randomGenerator.nextInt(200);
        return rndDeposit;
    }
    public void run() {
        accessLock.lock(); // Attempt to get the lock

        try {
            deposit();
            notify();
            Thread.sleep(randomGenerator.nextInt(30));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
