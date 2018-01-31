package com.conklin;


public class WithdrawThread implements Runnable {
    public String id;
    public BankAccount bankAccount;


    public WithdrawThread(String id, BankAccount bankAccount) {
        this.id = id;
        this.bankAccount = bankAccount;
    }

    public void run() {

    }
}
