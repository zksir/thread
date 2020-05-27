package com.zksir.synchroized;

/**
 * 对象锁示例1，代码块形式
 */
public class SynchronizedObjectCodeBlock implements Runnable {

    static SynchronizedObjectCodeBlock instance = new SynchronizedObjectCodeBlock();
//    Object lock1 = new Object();
//    Object lock2 = new Object();

//    @Override
//    public void run() {
//        synchronized(lock1) {
//            System.out.println("我是lock1。我叫" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "lock1运进行结束。");
//        }
//
//        synchronized(lock2) {
//            System.out.println("我是lock2。我叫" + Thread.currentThread().getName());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "lock2运进行结束。");
//        }
//    }

    @Override
    public void run() {
        synchronized(this) {
            System.out.println("我是对象锁代码块形式。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运进行结束。");
        }
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
