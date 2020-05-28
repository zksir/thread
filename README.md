# Java多线程学习
## com.zksir.synchroized----synchroized关键字学习
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
