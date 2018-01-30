package com.conklin;

import java.util.Random;

public class WithdrawThread implements Runnable {
    int rndWithdraw = 0;
    private static Random randomGenerator = new Random();

    private void withdraw() {
        rndWithdraw = randomGenerator.nextInt(50);
        System.out.println(String.format("Thread withdraws $%d", rndWithdraw));
    }
    public void run() {

    }
}
