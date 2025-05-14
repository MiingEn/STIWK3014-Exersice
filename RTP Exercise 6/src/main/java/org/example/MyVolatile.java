package org.example;

class MyThread extends Thread {
    private volatile boolean running = true; // Use volatile to ensure visibility across threads
    public void run() {
        while (running) {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown() {
        running = false;
    }
}

public class MyVolatile {
    public static void main(String[] args) throws Exception {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Press ENTER to stop the thread...");
        System.in.read(); // Wait for user to press ENTER
        t1.shutdown();
    }
}