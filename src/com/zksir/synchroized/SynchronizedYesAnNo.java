package com.zksir.synchroized;

/**
 * 同时访问同步方法和非同步方法
 */
public class SynchronizedYesAnNo implements Runnable {
    static SynchronizedYesAnNo instance1 = new SynchronizedYesAnNo();
    static SynchronizedYesAnNo instance2 = new SynchronizedYesAnNo();
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        } else {
            method2();
        }
    }
    public synchronized void method1() {
        System.out.println("我是加锁的方法，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public void method2() {
        System.out.println("我是没加锁的方法，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
