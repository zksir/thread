package com.zksir.threadcoreknowledge.startthread;

/**
 * 对比start和run两种启动线程的方式
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();// 第一种启动方法

        new Thread(runnable).start();// 第二种启动方法
    }
}
