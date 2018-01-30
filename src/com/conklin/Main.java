package com.conklin;

public class Main {

    public static void main(String[] args) {
        Thread depositThread1 = new Thread(new DepositThread("D1"));
        Thread depositThread2 = new Thread(new DepositThread("D2"));
        Thread depositThread3 = new Thread(new DepositThread("D3"));
        Thread depositThread4 = new Thread(new DepositThread("D4"));

        Thread withdrawThread1 = new Thread(new WithdrawThread("D1"));
        Thread withdrawThread2 = new Thread(new WithdrawThread("D2"));
        Thread withdrawThread3 = new Thread(new WithdrawThread("D3"));
        Thread withdrawThread4 = new Thread(new WithdrawThread("D4"));
        Thread withdrawThread5 = new Thread(new WithdrawThread("D5"));
        Thread withdrawThread6 = new Thread(new WithdrawThread("D6"));

    }
}
