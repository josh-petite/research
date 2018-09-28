package com.josh.bigO;

public class IntPair {
    int a;
    int b;

    IntPair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    static IntPair gen(int a, int b) {
        return new IntPair(a, b);
    }
}
