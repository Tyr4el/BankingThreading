package com.conklin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int currentBalance = 0;
    private Lock accessLock = new ReentrantLock();


    public void deposit(int amount) {
        accessLock.lock();
        currentBalance = currentBalance + amount;
        accessLock.unlock();
    }

    public boolean withdraw(int amount) {
        accessLock.lock();
        if (currentBalance >= amount) {
            currentBalance = currentBalance - amount;
            accessLock.unlock();
            return true;
        } else {
            accessLock.unlock();
            return false;
        }
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}
