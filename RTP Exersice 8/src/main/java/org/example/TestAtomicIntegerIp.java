package org.example;

import java.util.concurrent.atomic.AtomicInteger; // New modification

class TestAtomicIntegerIp {
    public static void main(String[] args) throws InterruptedException {
        CountProblem pt = new CountProblem(); // New modification

        Thread t1 = new Thread(pt, "t1"); // New modification
        Thread t2 = new Thread(pt, "t2"); // New modification

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count=" + pt.getCount()); // Should be 10
    }
}

class CountProblem implements Runnable {

    private AtomicInteger count = new AtomicInteger(0); // New modification

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) { // New modification: fix loop to go 1 to 5 (inclusive)
            processSomething(i);
            count.incrementAndGet(); // New modification: use atomic increment
        }
    }

    public int getCount() {
        return this.count.get(); // New modification
    }

    private void processSomething(int i) {
        try {
            Thread.sleep(1280);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
