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







