package com.zksir.threadcoreknowledge.stopthreads;

/**
 * @Describe 错误的停止方法：stop()停止线程，会导致线程运行一半突然停止，
 *           没办法完成一个基本单位的操作，会造成脏数据
 * 总结：stop是不安全的，会会释放掉对象中所有的监视器(monitor)
 *      suspend和resume会带着锁休眠，不释放锁，导致死锁
 */
public class StopThread implements Runnable {
    @Override
    public void run() {
        // 模拟指挥军队：一共5个连队，没个连队10人，以连队为单位，发放武器弹药，叫到号的士兵前去领取
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取武器");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(50);// 每个士兵领取时，要花50ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队" + i + "已经领取完毕");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);//突然接到命令，暂停领取武器，未领武器的到一线领
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();//stop会释放掉对象中所有的监视器(monitor)
    }
}
