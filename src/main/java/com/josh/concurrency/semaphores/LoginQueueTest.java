package com.josh.concurrency.semaphores;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LoginQueueTest {

    @Test
    public void givenLoginQueue_whenReachLimit_thenBlocked() {
        int slots = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginQueue loginQueue = new LoginQueue(slots);

        IntStream.range(0, slots)
                .forEach(user -> executorService.execute(loginQueue::tryLogin));

        executorService.shutdown();

        assertEquals(0, loginQueue.availableSlots());
        assertFalse(loginQueue.tryLogin());
    }
}
