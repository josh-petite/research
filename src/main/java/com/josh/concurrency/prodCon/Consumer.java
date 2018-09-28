package com.josh.concurrency.prodCon;

import java.util.List;

public class Consumer extends Threadable {

    private final List<Integer> sharedQueue;

    Consumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedQueue) {
                if (sharedQueue.size() == 0) {
                    waitForNotification(sharedQueue);
                } else {
                    long ns = clock(() -> sharedQueue.remove(0));
                    System.out.printf("(%s) consuming (%sns)%n", Thread.currentThread().getName(), ns);
                    sharedQueue.notify();
                }
            }
        }
    }
}
