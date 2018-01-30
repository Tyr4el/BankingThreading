package com.conklin;
import java.util.Random;

public class DepositThread implements Runnable {
    int rndDeposit = 0;
    private static Random randomGenerator = new Random();

    private void deposit() {
        rndDeposit = randomGenerator.nextInt(200);
        System.out.println(String.format("Thread deposits $%d", rndDeposit));
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
