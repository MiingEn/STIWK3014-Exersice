package org.example;

public class TestSleep {
    public static void main(String[] args) {
        int threadCount = 20;
        for (int i = 1; i <= threadCount; i++) {
            Thread t = new Thread(new PrintTask());
            t.start();
            try {
                t.join(); // Wait for this thread to finis before starting the next
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class PrintTask implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("ONE");
            Thread.sleep(100);
            System.out.println("TWO");
            Thread.sleep(100);
            System.out.println("THREE");
            Thread.sleep(100);
            System.out.println("XXXXXXXXXX");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}