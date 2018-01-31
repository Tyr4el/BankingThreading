package com.conklin;


import java.util.Random;

public class DepositThread implements Runnable {
    public String id;
    public BankAccount bankAccount;

    Random randomAmount = new Random();

    int randomDeposit = randomAmount.nextInt(200);


    public DepositThread(String id, BankAccount bankAccount) {
        this.id = id;
        this.bankAccount = bankAccount;
    }

    public void run() {
        while(true) {
            try {
                bankAccount.deposit(randomDeposit);
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }

    }
}