package org.example;

public class BankMain {
    public static void main(String[] args) {
        BankAccountWithLock account = new BankAccountWithLock(1000);

        // Create threads for reading balance
        Runnable reader = () -> {
            for (int i = 0; i < 3; i++) {
                account.getBalance();
                try { Thread.sleep(100); } catch (InterruptedException e) { }
            }
        };

        // Create threads for depositing and withdrawing
        Runnable depositor = () -> {
            account.deposit(200);
        };

        Runnable withdrawer = () -> {
            account.withdraw(150);
        };

        Thread t1 = new Thread(reader, "Reader-1");
        Thread t2 = new Thread(reader, "Reader-2");
        Thread t3 = new Thread(depositor, "Depositor");
        Thread t4 = new Thread(withdrawer, "Withdrawer");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

