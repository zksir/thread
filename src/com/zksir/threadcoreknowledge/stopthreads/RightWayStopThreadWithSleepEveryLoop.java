package com.zksir.threadcoreknowledge.stopthreads;

/**
 * @Describe 如果在执行过程中，每次循环都调用sleep或wait等方法，
 *           那么不需要每次迭代都检查是否已中断
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
                    if (num % 100 == 0) {// 这里不需要使用!Thread.currentThread().isInterrupted()来接收中断信号，
                        // 因为每次循环都睡眠10毫秒，当外部发出中断信号时，try catch就已经捕获到了外部的中断信号
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
