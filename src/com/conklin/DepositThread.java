package com.conklin;


public class DepositThread implements Runnable {
    public String id;
    public BankAccount bankAccount;


    public DepositThread(String id, BankAccount bankAccount) {
        this.id = id;
        this.bankAccount = bankAccount;
    }

    public void run() {

    }
}