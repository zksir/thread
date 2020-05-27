package com.zksir.synchroized;

/**
 * 对象锁示例2，方法锁形式
 */
public class SynchronizedObjectMethodBlock implements Runnable {
    static SynchronizedObjectMethodBlock instance = new SynchronizedObjectMethodBlock();
    @Override
    public void run() {
        method();
    }
    public synchronized void method() {
        System.out.println("我是对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
