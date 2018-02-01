package com.conklin;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        // Print formatter for headings
        System.out.printf("%-40s%s\t\t\t\t%s\n%-40s%s\t\t\t\t%s", "Deposit Threads", "Withdraw Threads", "Balance",
                "----------------", "----------------", "-------\n");

        Thread depositThread1 = new Thread(new DepositThread("D1", bankAccount), "D1"); // Create thread D1
        Thread depositThread2 = new Thread(new DepositThread("D2", bankAccount), "D2"); // Create thread D2
        Thread depositThread3 = new Thread(new DepositThread("D3", bankAccount), "D3"); // Create thread D3
        Thread depositThread4 = new Thread(new DepositThread("D4", bankAccount), "D4"); // Create thread D4

        Thread withdrawThread1 = new Thread(new WithdrawThread("W1", bankAccount), "W1"); // Create thread W1
        Thread withdrawThread2 = new Thread(new WithdrawThread("W2", bankAccount), "W2"); // Create thread W2
        Thread withdrawThread3 = new Thread(new WithdrawThread("W3", bankAccount), "W3"); // Create thread W3
        Thread withdrawThread4 = new Thread(new WithdrawThread("W4", bankAccount), "W4"); // Create thread W4
        Thread withdrawThread5 = new Thread(new WithdrawThread("W5", bankAccount), "W5"); // Create thread W5
        Thread withdrawThread6 = new Thread(new WithdrawThread("W6", bankAccount), "W6"); // Create thread W6

        depositThread1.start();
        depositThread2.start();
        depositThread3.start();
        depositThread4.start();

        withdrawThread1.start();
        withdrawThread2.start();
        withdrawThread3.start();
        withdrawThread4.start();
        withdrawThread5.start();
        withdrawThread6.start();

    }
}
