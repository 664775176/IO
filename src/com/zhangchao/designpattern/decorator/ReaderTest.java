package com.zhangchao.designpattern.decorator;

import java.io.*;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ReaderTest
 * @description: TODO
 * @date 2018/11/15 18:38
 */
public class ReaderTest {
    public static void main(String []args)throws IOException {
        Reader reader = new FileReader("");  //FileReader里面还是使用了InputStream
        LineNumberReader b = new LineNumberReader(new BufferedReader(reader));
        Reader reader1 = new InputStreamReader(new FileInputStream(""));
        PushbackReader p = new PushbackReader(reader1);


    }
}
