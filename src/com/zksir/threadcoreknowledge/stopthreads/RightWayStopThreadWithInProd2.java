package com.zksir.threadcoreknowledge.stopthreads;

/**
 * @Describe 最佳实践2：在catch子句中调用Thread.currentThread().interrupt()
 *           来恢复设置中断状态，以便于在后续的执行中，依然能够检查到刚才发生了中断
 * 回到刚才RightWayStopThreadWithInProd补上中断，让它跳出
 */
public class RightWayStopThreadWithInProd2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted,运行结束");
                break;
            }
            reInterrupt();
        }
    }

    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();//重点是这里，传递中断
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
