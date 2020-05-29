package com.zksir.threadcoreknowledge.createthreads;

/**
 * 用Thread方式创建线程
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread类创建线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
