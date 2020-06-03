package com.zksir.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Describe 演示join，注意语句输出顺序，会变化。
 * 作用：因为新的线程加入，所以要等待他执行完再出发
 * 用法：main等待thread1执行完毕，注意谁等谁
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);// 子线程先睡一秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);// 子线程先睡一秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread.start();
        thread2.start();
        System.out.println("开始等待子线程运行完毕");
        thread.join();// 可以注释掉这两句看效果
        thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}
