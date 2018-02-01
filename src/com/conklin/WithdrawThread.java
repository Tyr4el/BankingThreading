package com.conklin;


import java.util.Random;

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
                int randomSleep = randomAmount.nextInt(5000);
                if (!bankAccount.withdraw(randomWithdraw)) {
                    System.out.println(String.format("\t\t\t\t\t\t\t\t\t\tThread " + this.id + " withdraws $%d Withdrawal " +
                            "- Blocked - Insufficient Funds", randomWithdraw)); // Print a message saying that it failed
                    // Block the thread here
                    Thread.sleep(randomSleep);
                } else {
                    bankAccount.withdraw(randomWithdraw);
                    System.out.println(String.format("\t\t\t\t\t\t\t\t\t\tThread " + this.id + " withdraws $%d\t" +
                            "\t\t$%d", randomWithdraw, bankAccount.getCurrentBalance()));
                    Thread.sleep(randomSleep);
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }
    }
}
