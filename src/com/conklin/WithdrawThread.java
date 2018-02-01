package com.conklin;


import java.util.Random;
import java.util.concurrent.locks.Condition;

public class WithdrawThread implements Runnable {
    private String id;
    private BankAccount bankAccount;

    Random randomAmount = new Random();


    public WithdrawThread(String id, BankAccount bankAccount) {
        this.id = id;
        this.bankAccount = bankAccount;
    }

    public void run() {
        while(true) {
            try {
                int randomWithdraw = randomAmount.nextInt(50);
                if (!bankAccount.withdraw(randomWithdraw)) {
                    // Block the thread here
                    bankAccount.getCanWithdraw().await();
                    Thread.sleep(3000);
                } else {
                    Thread.sleep(4000);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }
    }
}
