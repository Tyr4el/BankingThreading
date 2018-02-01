package com.conklin;


import java.util.Random;

public class DepositThread implements Runnable {
    private String id;
    private BankAccount bankAccount;

    Random randomAmount = new Random();

    public DepositThread(String id, BankAccount bankAccount) {
        this.id = id;
        this.bankAccount = bankAccount;
    }

    public void run() {
        while(true) {
            try {
                int randomDeposit = 1 +randomAmount.nextInt(199);
                bankAccount.deposit(randomDeposit);
                bankAccount.signalAll();
                Thread.sleep(4000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }

    }
}