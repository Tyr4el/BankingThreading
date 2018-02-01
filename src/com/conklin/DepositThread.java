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
                int randomDeposit = randomAmount.nextInt(200);
                bankAccount.deposit(randomDeposit);
                System.out.println(String.format("Thread " + this.id + " deposits $%d\t\t\t\t\t\t\t\t\t" +
                                "\t\t\t\t$%d", randomDeposit, bankAccount.getCurrentBalance()));
                Thread.sleep(3000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } finally {
                this.notifyAll();
            }

        }

    }
}