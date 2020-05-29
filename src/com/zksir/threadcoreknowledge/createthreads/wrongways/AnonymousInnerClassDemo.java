package com.zksir.threadcoreknowledge.createthreads.wrongways;

/**
 * 匿名内部类实现创建线程
 */
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        // 第一种匿名内部类实现方法
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        // 第二种匿名内部类实现方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
