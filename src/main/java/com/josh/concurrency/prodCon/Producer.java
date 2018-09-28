package com.josh.concurrency.prodCon;

import java.util.List;

public class Producer extends Threadable {

    private final List<Integer> sharedQueue;

    Producer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            synchronized (sharedQueue) {
                int finalI = i;
                System.out.printf("(%s) producing %d (%sns)%n",
                        Thread.currentThread().getName(), i, clock(() -> sharedQueue.add(finalI)));

                sharedQueue.notify();
                waitForNotification(sharedQueue);
            }
        }
    }
}
