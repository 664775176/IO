package com.zhangchao.object;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Date;

public class StrongReferenceTest {

    public static void main(String[] args) {
        Date date = new Date();
        System.gc();

        SoftReference ref = new SoftReference(new Date());
        System.gc();

        WeakReference ref1 = new WeakReference(new Date());
        System.gc();

        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref2 = new PhantomReference(new Date(), queue);
        System.gc();
    }
}