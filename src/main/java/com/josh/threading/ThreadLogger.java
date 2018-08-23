package com.josh.threading;

public class ThreadLogger {

    private static int x = 0;

    public static void increment(int amount) {
        x += amount;
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                public void run() {

                    ThreadLogger.increment(5);
                    System.out.println("Thread: " + getName() + " complete");
                }
            }.start();
        }

        Thread.sleep(1000);
        System.out.println("X: " + x);
    }
}
