# Java多线程学习
## threadcoreknowledge包----线程核心知识基础
### createthreads包 创建线程
    1、实现多线程的方法是1种还是2种还是4种？
        Oracle官方：2种，一种是将类声明为Thread子类，第二种是实现Runnable接口。
        - RunnableStyle 用Runnable方式创建线程
        - ThreadStyle 用Thread方式创建线程
        对比：实现Runnable接口更好，java是单继承，多接口，可以解耦
        本质：Runnable最终调用target.run();ThreadStyle方法run()整个都被重写
        - BothRunnableThread 同时使用Runnable和Thread两种实现线程的方式
        准确的讲，创建线程只有一种方式，那就是构造Thread类，而实现线程的执行单元有两种方式
        
        - ThreadPool 线程池创建线程的方法-本质是new Thread
        - DemoTimmerTask 定时器创建线程
        - AnonymousInnerClassDemo 匿名内部类实现创建线程
        - Lambda lambda表达式创建线程

### startthread包 启动线程
    2、启动线程正确和错误的方式
    - StartAndRunMethod 对比start和run两种启动线程的方式
    - CantStartTwice 演示不能两次调用start方法，否则会报错
         * start源码解析：
            *      启动新线程检查线程状态
            *      加入线程组
            *      调用start0()
         * run源码解析：
            *      if (target != null) {
            *         target.run();
            *      }
### stopthreads包 停止线程
    3、如何正确停止线程？
        原理：使用interrupt来通知，而不是强制
        线程停止的两种情况：1.所有代码都运行完毕；2.有异常出现，异常未被捕获
    - RightWayStopThreadWithoutSleep run方法没有sleep或wait方法时，停止线程
    - RightWayStopThreadWithSleep 带有sleep的中断线程的写法
    - RightWayStopThreadWithSleepEveryLoop 如果在执行过程中，每次循环都调用sleep或wait等方法，那么不需要每次迭代都检查是否已中断
    - CantInterrupt 如果while里面放try/catch，会导致中断失效，sleep的线程一旦响应中断，会清除线程的中断标记位
        实际开发中两种最佳的中断实践
    - RightWayStopThreadWithInProd 最佳实践1：catch住了InterruptedExcetion之后，优先选择：
                                    * 在方法签名中抛出异常
                                    * 那么在run()就会强制try/catch
    - RunThrowException run无法抛出checked Exception,只能用try/catch
    - RightWayStopThreadWithInProd2 最佳实践2：在catch子句中调用Thread.currentThread().interrupt()
                                     *           来恢复设置中断状态，以便于在后续的执行中，依然能够检查到刚才发生了中断
                                     * 回到刚才RightWayStopThreadWithInProd补上中断，让它跳出
                                     
         响应中断方法总结
         Object.wait()/wait(long)/wait(long,int)
         Thread.sleep(long,int)/sleep(long)
         Thread.join()/join(long)/join(long,int)
         java.util.concurrent.BlockingQueue.take()/put(E)
         java.util.concurrent.locks.Lock.lockInterruptibly()
         java.util.concurrent.CountDownLatch.await()
         java.util.concurrent.CyclicBarrier.await()
         java.util.concurrent.Exchanger.exchang(V)
         java.nio.channles.InterruptibleChannel相关方法
         java.nio.channles.Selector相关方法
         
        停止线程错误的方法
        总共两大种错误的停止方法：
         (1) 被弃用的stop()/suspend()和resume()
         (2) 用volatile设置Boolean标记位
    - StopThread 错误的停止方法：stop()停止线程，会导致线程运行一半突然停止，
                   *           没办法完成一个基本单位的操作，会造成脏数据
                   * 总结：stop是不安全的，会会释放掉对象中所有的监视器(monitor)
                   *      suspend和resume会带着锁休眠，不释放锁，导致死锁
        volatile包
    - WrongWayVolatile 演示用volatile的局限：part1,演示看似可行的部分
    - WrongWayVolatileCantStop 演示用volatile的局限：part2 陷入阻塞时，volatile是无法停止线程的
    - WrongWayVolatileFixed 用中断来修复刚才无尽等待的问题
        停止线程相关重要函数
    - RightWayInterrupted Thread.interrupted()方法的目标对象是“当前线程”，而不管本方法来自于哪个对象
### sixstates包 六个线程状态
    - NewRunnableTerminated 展示线程New,Runnable,Terminated三种状态。即使是正在运行，也是Runnable状态，而不是Running
    - BlockedWaitingTimedWaiting 展示Blocked,Waiting,TimedWaiting
### threadobjectclasscommonmethods包 Thread类和Object类重要方法
    - Wait 展示wait和notify的基本用法 1. 研究代码执行顺序 2. 证明wait释放锁
    - WaitNotifyAll 3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify, notifyAll。 start先执行不代表线程先启动。
        wait,notify,notifyAll性质：使用必先拥有monitor,notify只能唤醒一个，属于Object类，类似功能，Condition
    - WaitNotifyReleaseOwnMonitor 证明wait只释放当前那把锁
    - ProducerConsumerModel 用wait/notify来实现生产者消费者模式 (最好能默写)
    - WaitNotifyPrintOddEvenSyn 两个线程交替打印0~100的奇偶数，用synchronized关键字实现
    - WaitNotifyPrintOddEveWait 两个线程交替打印0~100的奇偶数，用wait和notify
    - SleepDontReleaseMonitor 展示线程sleep的时候不释放synchronized的monitor，等sleep时间到了以后，正常结束后才释放锁
    - SleepDontReleaseLock 演示sleep不释放lock（lock需要手动释放）
    - SleepInterrupted  每个1秒钟输出当前时间，被中断，观察。 
                        * 1.抛出InterruptedException
                        * 2.清除中断状态
    - Join 演示join
            * 作用：因为新的线程加入，所以要等待他执行完再出发
            * 用法：main等待thread1执行完毕，注意谁等谁
    - JoinInterrupt 演示join期间被中断的效果
    - JoinPrinciple join原理，join的代替写法
    - CurrentThread 演示打印main, Thread-0, Thread-1
    - ID从1开始，JVM运行起来后，我们自己创建的线程的ID早已不是2.
### uncaughtexception包 线程未捕获异常处理
    - CantCatchDirectly 说明线程的异常不能用传统方法捕获
    - ExceptionInChildThread 单线程，抛出，处理，有异常堆栈 多线程，子线程发生异常
    - MyUncaughtExceptionHandler 自己的MyUncaughtExceptionHanlder
    - UseOwnUncaughtExceptionHandler 使用刚才自己写的UncaughtExceptionHandler
    
## background包 线程安全
    - MultiThreadsError 第一种：运行结果出错。 演示计数不准确（减少），找出具体出错的位置。
    - MultiThreadError 第二种线程安全问题，演示死锁。
    - MultiThreadsError3 发布逸出
    - MultiThreadsError4 初始化未完毕，就this赋值
    - MultiThreadsError5 观察者模式
    - MultiThreadsError6 构造函数中新建线程
    - MultiThreadsError7 用工厂模式修复刚才的初始化问题
    
    
## synchroized包----synchroized关键字学习
    - 消失的请求 DisappearRequest
    - 对象锁示例1，代码块形式 SynchronizedObjectCodeBlock
    - 对象锁示例2，方法锁形式 SynchronizedObjectMethodBlock
    - 类锁的第一种形式，static形式 SynchronizedClassStatic
    - 类锁的第二种形式，synchronized(*class)形式 SynchronizedClassClass
    - 同时访问同步方法和非同步方法 SynchronizedYesAnNo
    - 同时访问一个类的不同的普通同步方法 SynchronizedDifferentMethod
    - 同时访问静态的synchronized和非静态synchronized方法 SynchronizedStaticAndNormal
    - 方法抛异常后，会释放锁 SynchronizedException
    - 可重入粒度测试1：递归调用本方法 SynchronizedRecursion
    - 可重入粒度测试2：调用类内部另外的方法 SynchronizedOtherMethod
    - 可重入粒子测试，调用父类方法 SynchronizedSuperClass
    - Synchronized锁与Lock锁类比 SynchronizedToLock
    - 反编译字节码 Decompilation
    - Lock示例







