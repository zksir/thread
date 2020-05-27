package com.zksir.synchroized;

/**
 * 消失的请求
 *      分析：两个线程同时i++,最后结果会比预计的少
 *      原因：count++,它看上去只是一个操作，实际包含了三个动作
 *          1、读取count
 *          2、将count加1
 *          3、将count的值写入到内存中
 */
public class DisappearRequest implements Runnable {

    static DisappearRequest instance = new DisappearRequest();
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
