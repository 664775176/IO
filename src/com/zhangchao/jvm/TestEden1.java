package com.zhangchao.jvm;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:TestEden1
 * @description: TODO
 * @date 2019/3/5 16:16
 */
public class TestEden1 {
    private static final int _1M = 1024 * 1024;

    private static void testMinorGC() {

        /* eden space为8M，from/to space各为1M */
        LargeObject largeOb1 = new LargeObject(_1M * 1 / 2, "largeOb1");
        LargeObject largeOb2 = new LargeObject(_1M * 1, "largeOb2");
        LargeObject largeOb3 = new LargeObject(_1M * 2, "largeOb3");
        largeOb3 = null;
        LargeObject largeOb4 = new LargeObject(_1M * 3, "largeOb4");
        LargeObject largeOb5 = new LargeObject(_1M * 2, "largeOb5");
    }

    public static void main(String[] agrs) {
        testMinorGC();
    }

    static class LargeObject {
        private byte[] data;
        private String name;

        public LargeObject(int size, String name) {
            data = new byte[size];
            this.name = name;
//            System.out.println("Over Constructing LargeObject " + name + System.lineSeparator());
        }

        public String getName() {
            return name;
        }
    }
}
