package com.zhangchao.juc.atomic;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:AtomicCharTest
 * @description: TODO
 * @date 2019/3/19 16:38
 */
public class AtomicCharTest {
    static AtomicChar atomicChar = new AtomicChar('1');
    public static void main(String[] args) {
        char c1 = atomicChar.getAndSet('d');
        System.out.println(c1);
        System.out.println(atomicChar.get());
    }
}
