package com.conklin;
import java.util.Random;

public class DepositThread implements Runnable, BankAccount {
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DepositThread(String id) {
        this.id = id;
    }

    int rndDeposit = 0;
    private static Random randomGenerator = new Random();

    public void deposit() {
        rndDeposit = randomGenerator.nextInt(200);
        System.out.println(String.format("Thread " + this.getId() + " deposits $%d", rndDeposit));
    }

    public void withdraw() {

    }

    public void run() {
        try {
            // Deposit a random amount
            deposit();
            // Sleep for a random amount of time
            Thread.sleep(randomGenerator.nextInt(30));
        } catch (InterruptedException e) { // Same catch as from Producer/Consumer problem in class
            e.printStackTrace();
        }
    }
}
