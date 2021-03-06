package com.zksir.threadcoreknowledge.startthread;

/**
 * 演示不能两次调用start方法，否则会报错
 * IllegalThreadStateException 非法的线程状态
 * start源码解析：
 *      启动新线程检查线程状态
 *      加入线程组
 *      调用start0()
 * run源码解析：
 *      if (target != null) {
 *         target.run();
 *      }
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.run();
        thread.start();
    }
}
