package org.example;

public class MultiplicationTableThread {
    public static void main(String[] args) {
        // Create and start three threads for numbers 1 to 3
        for (int i = 1; i <= 3; i++) {
            int num = i;
            Thread thread = new Thread(() -> {
                for (int j = 1; j <= 3; j++) {

                    System.out.println(Thread.currentThread().getName() + ": "
                            + num + "*" + j + "=" + (num * j));
                    try {
                        Thread.sleep(100); // Just to simulate delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.setName("Thread-" + (i - 1)); // Namin the thread as Thread-0, Thread-1, etc.
                    thread.start();
        }
    }
}