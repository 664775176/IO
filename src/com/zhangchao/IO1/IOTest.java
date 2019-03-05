package com.zhangchao.IO1;

import java.io.*;

public class IOTest {
    public static void main(String args[]) throws Exception{
        String[] name = new String[1000];

        for(int i=0; i< 10000000; i++) {
//            name[i] = "fr"+i;
            new FileOutputStream("C:\\Users\\23066\\Desktop\\PO2同步现有问题0.1").write(i);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            String s;
            while ((s = reader.readLine()) != null) {
                if (s.equalsIgnoreCase("quit")){
                    break;
                }
                System.out.println(s.toUpperCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        String str = null;
//        while((str = bufferedReader.readLine()) != null) {
//            System.out.println(str);
//        }

//        InputStream is = new ByteArrayInputStream("123456789".getBytes());
//        InputStream bis = new DataInputStream(is);
//
//        System.out.println("char:" + (char)bis.read());
//        System.out.println("char:" + (char)bis.read());
//        System.out.println("-------mark(3)----------");
//        bis.mark(3);
//        System.out.println("char:" + (char)bis.read());
//        System.out.println("char:" + (char)bis.read());
//        System.out.println("char:" + (char)bis.read());
//        bis.reset();
//        System.out.println("-------reset()----------");
//
//        int b = 0;
//        while((b = bis.read())!= -1) {
//            System.out.println("size:" + b);
//            System.out.println("char:" + (char)b);
//        }
//        FileInputStream fis = new FileInputStream("C:\\Users\\23066\\Desktop\\PO2同步现有问题0.1");
//        DataInputStream dis = new DataInputStream(fis);
//        System.out.println(dis.readBoolean());
////        System.out.println(dis.readChar());
//        System.out.println(dis.readUTF());
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\23066\\Desktop\\PO2同步现有问题0.1"));
////        char[] c = new char[1];
////        int i = 0;
//////        while((i = isr.read(c)) != -1) {
//////            System.out.print(new String(c, 0, i));
//////        }
////        i = isr.read(c);
////        System.out.print(new String(c, 0, i));
////        i = isr.read(c);
////        System.out.print(new String(c, 0, i));
////        i = isr.read(c);
////        System.out.print(new String(c, 0, i));
////        i = isr.read(c);
//        System.out.print("i:"+i +" char: "+ c[0] + ",neirong:" +  new String(c, 0, i));
//        int j = isr.read(c);
//        System.out.println(j+":"+new String(c, 0, j));
//        j = isr.read(c);
//        System.out.println(j+":"+new String(c, 0, j));
//        char[] buf=new char[1024];
//        FileReader fr=new FileReader("C:\\\\Users\\\\23066\\\\Desktop\\\\PO2同步现有问题0.1");
//        int num=0;
//        while((num=fr.read(buf))!=-1){
////继续读还是往buf里面装所以前面的会被后面进来的替代了
//            System.out.print(new String(buf,0,num));
//
//            /*因为read(char[])返回的是字符的个数，当打印长度不够1024时，则直接返回的是个数，因为我们是将字符数组buf打印成字符串，所以不足1024的时候得使用new String(char[] ,0,num);(从哪开始到哪结束)*/
//
//        }
    }
}
