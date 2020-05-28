package com.zksir.synchroized;

/**
 * 可重入粒子测试，调用父类方法
 */
public class SynchronizedSuperClass {
    public synchronized void doSomething() {
        System.out.println("我是父类方法");
    }
}

class TestClass extends SynchronizedSuperClass{
    public synchronized void doSomething() {
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.doSomething();
    }
}
