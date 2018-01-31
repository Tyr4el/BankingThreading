package com.conklin;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        // Print formatter for headings
        System.out.printf("%-40s%s\t\t%s\n%-40s%s\t\t%s", "Deposit Threads", "Withdraw Threads", "Balance",
                "----------------", "----------------", "-------");

        Thread depositThread1 = new Thread(new DepositThread("D1", bankAccount)); // Create thread D1
        Thread depositThread2 = new Thread(new DepositThread("D2", bankAccount)); // Create thread D2
        Thread depositThread3 = new Thread(new DepositThread("D3", bankAccount)); // Create thread D3
        Thread depositThread4 = new Thread(new DepositThread("D4", bankAccount)); // Create thread D4

        Thread withdrawThread1 = new Thread(new WithdrawThread("W1", bankAccount)); // Create thread W1
        Thread withdrawThread2 = new Thread(new WithdrawThread("W2", bankAccount)); // Create thread W2
        Thread withdrawThread3 = new Thread(new WithdrawThread("W3", bankAccount)); // Create thread W3
        Thread withdrawThread4 = new Thread(new WithdrawThread("W4", bankAccount)); // Create thread W4
        Thread withdrawThread5 = new Thread(new WithdrawThread("W5", bankAccount)); // Create thread W5
        Thread withdrawThread6 = new Thread(new WithdrawThread("W6", bankAccount)); // Create thread W6

    }
}
