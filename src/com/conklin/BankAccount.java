package com.conklin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int currentBalance = 0;
    private Lock accessLock = new ReentrantLock();


    public void deposit(int amount) {
        try {
            accessLock.lock();
            currentBalance = currentBalance + amount;
            System.out.println(String.format("Thread " + Thread.currentThread().getName() + " deposits $%d\t\t\t\t\t\t\t\t\t" +
                    "\t\t\t\t$%d", amount, currentBalance ));
        } finally {
            accessLock.unlock();
        }

    }

    public boolean withdraw(int amount) {
        try {
            accessLock.lock();
            if (currentBalance >= amount) {
                currentBalance = currentBalance - amount;
                System.out.println(String.format("\t\t\t\t\t\t\t\t\t\tThread " + Thread.currentThread().getName() + " withdraws $%d\t" +
                        "\t\t$%d", amount, currentBalance));
                return true;
            } else {
                return false;
            }
        } finally {
            accessLock.unlock();
        }

    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}
