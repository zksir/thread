package com.zksir.synchroized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized锁与Lock锁类比
 */
public class SynchronizedToLock {

    Lock lock = new ReentrantLock();

    public synchronized void method1() {
        System.out.println("我是synchronized形式的锁");
    }

    public void method2() {
        lock.lock();
        try {
            System.out.println("我是lock形式的锁");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock s = new SynchronizedToLock();
        s.method1();
        s.method2();
    }
}
