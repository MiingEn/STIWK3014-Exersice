package org.example;

public class ComparisonThreads {

    public static void main(String[] args) throws InterruptedException {

        Counter normalCounter = new Counter();
        Thread[] normalThreads = new Thread[10];
        long startNormal = System.nanoTime();

        for (int i = 0; i < 10; i++) {
            normalThreads[i] = new NormalThread(normalCounter);
            normalThreads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            normalThreads[i].join();
        }

        long endNormal = System.nanoTime();
        double durationNormal = (endNormal - startNormal) / 1_000_000_000.0;

        Counter syncCounter = new Counter();
        Thread[] syncThreads = new Thread[10];
        long startSync = System.nanoTime();

        for (int i = 0; i < 10; i++) {
            syncThreads[i] = new SynchronizedThread(syncCounter);
            syncThreads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            syncThreads[i].join();
        }

        long endSync = System.nanoTime();
        double durationSync = (endSync - startSync) / 1_000_000_000.0;

        System.out.printf("Normal thread = %.9f seconds%n", durationNormal);
        System.out.printf("Synchronized thread = %.9f seconds%n", durationSync);
    }
}

class Counter {
    int count = 0;

    public void increment() {
        count++;
    }

    public synchronized void synchronizedIncrement() {
        count++;
    }
}

class NormalThread extends Thread {
    private final Counter counter;

    public NormalThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class SynchronizedThread extends Thread {
    private final Counter counter;

    public SynchronizedThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.synchronizedIncrement();
        }
    }
}
