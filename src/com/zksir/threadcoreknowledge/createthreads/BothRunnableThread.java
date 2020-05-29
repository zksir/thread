package com.zksir.threadcoreknowledge.createthreads;

/**
 * 同时使用Runnable和Thread两种实现线程的方式
 * 准确的讲，创建线程只有一种方式，那就是构造Thread类，而实现线程的执行单元有两种方式
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
