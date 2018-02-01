package com.conklin;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int currentBalance = 0;
    private Lock accessLock = new ReentrantLock();
    private Condition canWithdraw = accessLock.newCondition();


    public void deposit(int amount) {
        try {
            accessLock.lock();
            currentBalance = currentBalance + amount;
            System.out.println(String.format("Thread " + Thread.currentThread().getName() + " deposits $%d\t\t\t\t\t\t\t\t\t" +
                    "$%d", amount, currentBalance ));
        } finally {
            accessLock.unlock();
        }

    }

    public boolean withdraw(int amount) {
        try {
            accessLock.lock();
            if (currentBalance >= amount) {
                currentBalance = currentBalance - amount;
                System.out.println(String.format("\t\t\t\t\tThread " + Thread.currentThread().getName() + " withdraws $%d\t" +
                        "\t\t\t$%d", amount, currentBalance));
                return true;
            } else {
                System.out.println(String.format("\t\t\t\t\tThread " + Thread.currentThread().getName() +
                        " withdraws $%d Withdrawal - Blocked - Insufficient Funds", amount));
                return false;
            }
        } finally {
            accessLock.unlock();
        }

    }

    public void await() throws InterruptedException {
        accessLock.lock();
        try {
            canWithdraw.await();
        } finally {
            accessLock.unlock();
        }
    }

    public void signalAll() {
        accessLock.lock();
        try {
            canWithdraw.signalAll();
        } finally {
            accessLock.unlock();
        }
    }

    public Condition getCanWithdraw() {
        return canWithdraw;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}
