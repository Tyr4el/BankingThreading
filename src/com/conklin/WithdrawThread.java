package com.conklin;

import java.util.Random;

public class WithdrawThread implements Runnable, BankAccount {
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WithdrawThread(String id) {
        this.id = id;
    }

    int rndWithdraw = 0;
    private static Random randomGenerator = new Random();

    public void withdraw() {
        rndWithdraw = randomGenerator.nextInt(50);
        System.out.println(String.format("Thread " + this.getId() + " withdraws $%d", rndWithdraw));
    }

    public void deposit() {

    }

    public void run() {

    }
}
