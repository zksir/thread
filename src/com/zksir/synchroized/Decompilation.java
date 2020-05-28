package com.zksir.synchroized;

/**
 * 反编译字节码
 *  1、编译javac Decompilation
 *  2、反编译（反汇编）javap -verbose(具体的) Decompilation.class
 */
public class Decompilation {
    private Object object = new Object();

    public void insert(Thread thread) {
        synchronized (object) {

        }
    }
}
