package com.conklin;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DepositThread implements Runnable {
    int rndDeposit = 0;
    private static Random randomGenerator = new Random();
    private Lock accessLock = new ReentrantLock();

    public void deposit() {
        rndDeposit = randomGenerator.nextInt(200);
        System.out.println(String.format("Thread deposits $%d", rndDeposit));
        return;
    }
    public void run() {
        accessLock.lock(); // Attempt to get the lock

        try {
            // Deposit a random amount
            deposit();
            // Unlock the lock so it can be used again
            accessLock.unlock();
            // Notify other threads that the lock is open to be grabbed
            notify();
            // Sleep for a random amount of time
            Thread.sleep(randomGenerator.nextInt(30));
        } catch (InterruptedException e) { // Same catch as from Producer/Consumer problem in class
            e.printStackTrace();
        }
    }
}
