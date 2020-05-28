package com.zksir.synchroized;

/**
 * 可重入粒度测试2：调用类内部另外的方法
 */
public class SynchronizedOtherMethod {

    public synchronized void method1() {
        System.out.println("这是method1");
        method2();
    }

    public synchronized void method2() {
        System.out.println("这是method2");
    }

    public static void main(String[] args) {
        SynchronizedOtherMethod s = new SynchronizedOtherMethod();
        s.method1();
    }
}
