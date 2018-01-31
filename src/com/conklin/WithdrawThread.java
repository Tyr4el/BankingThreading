package com.conklin;


import java.util.Random;

public class WithdrawThread implements Runnable {
    public String id;
    public BankAccount bankAccount;

    Random randomAmount = new Random();

    int randomWithdraw = randomAmount.nextInt(50);


    public WithdrawThread(String id, BankAccount bankAccount) {
        this.id = id;
        this.bankAccount = bankAccount;
    }

    public void run() {

    }
}
