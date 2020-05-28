package com.zksir.synchroized;

/**
 * 反编译字节码
 */
public class Decompilation {
    private Object object = new Object();

    public void insert(Thread thread) {
        synchronized (object) {

        }
    }
}
