package com.zhangchao.test;

import java.nio.channels.Selector;

public class TestSelector {
    private static final int MAXSIZE = Integer.MAX_VALUE/1024;

    public static void  main(String args[]) {
        Selector []size = new Selector[MAXSIZE];
        try {
            for(int i=0; i < MAXSIZE; i++) {
                size[i] = Selector.open();
            }
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
