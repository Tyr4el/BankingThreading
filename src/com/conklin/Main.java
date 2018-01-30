package com.conklin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Thread depositThread = new Thread(new DepositThread());
        Thread withdrawThread = new Thread(new WithdrawThread());
    }
}
