package com.josh.concurrency.prodCon;

abstract class Threadable implements Runnable {
    void waitForNotification(Object mutex) {
        try {
            System.out.printf("(%s) waiting...%n", Thread.currentThread().getName());
            mutex.wait();
        } catch (InterruptedException e) {
            System.out.printf("InterruptedException in thread: (%s)%n", Thread.currentThread().getName());
        }
    }

    long clock(Runnable r) {
        long start = System.nanoTime();
        r.run();
        return System.nanoTime() - start;
    }
}
