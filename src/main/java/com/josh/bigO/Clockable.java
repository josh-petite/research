package com.josh.bigO;

import java.util.function.Supplier;

public abstract class Clockable {
    protected static <T> T run(Supplier<T> supplier) {
        long start = System.currentTimeMillis();
        T result = supplier.get();
        System.out.printf("Elapsed: %dms%n", System.currentTimeMillis() - start);

        return result;
    }
}
