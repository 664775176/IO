package com.zhangchao.juc.atomic;

import sun.misc.Unsafe;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:AtomicChar
 * @description: TODO
 * @date 2019/3/19 15:49
 */
public class AtomicChar implements java.io.Serializable {
    private static final long serialVersionUID = 4654671469794556979L;
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicChar.class.getDeclaredField("value"));
        } catch (Exception e)
        {
            throw new Error(e);
        }
    }

    private volatile int value;

    public AtomicChar(char c) {
        value = c;
    }

    public char get(){
        return (char)value;
    }

    public void set(char c){
        value = c;
    }

    public boolean compareAndSwap(char expect, char update) {
        return unsafe.compareAndSwapInt(value, valueOffset, expect, update);
    }

    public char getAndSet(char c) {
        char preValue;
        do{
            preValue = get();
        } while(!compareAndSwap(preValue, c));
        return preValue;
    }
}
