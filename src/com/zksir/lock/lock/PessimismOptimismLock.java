package com.zksir.lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：     演示锁可见性保证（乐观锁）
 */
public class PessimismOptimismLock {

    int a;

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }

    public synchronized void testMethod() {
        a++;
    }


}
