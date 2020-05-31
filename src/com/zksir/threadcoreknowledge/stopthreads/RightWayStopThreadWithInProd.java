package com.zksir.threadcoreknowledge.stopthreads;

/**
 * @Describe 最佳实践1：catch住了InterruptedExcetion之后，优先选择：
 * 在方法签名中抛出异常
 * 那么在run()就会强制try/catch
 */
public class RightWayStopThreadWithInProd implements Runnable {
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
//            throwInMethod();
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                // 保存日志，停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    private void throwInMethod() throws InterruptedException {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
