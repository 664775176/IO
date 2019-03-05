package com.zhangchao.test;

import java.util.Date;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:MyObject
 * @description: TODO
 * @date 2018/12/1 15:46
 */
public class MyObject {
 private static MyObject obj;
 private Date d = new Date();
 public Date getD(){return this.d;}
 public static int count;
 public MyObject(){
     count++;
 }
 public static MyObject getInstance(){
 if(obj == null){
 synchronized(MyObject .class){
 if(obj == null)
 obj = new MyObject();//这里
 }
 }
return obj;
 }

 public static void main(String args[])throws Exception {
     for(int i=0; i<1000;i++) {
         Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 getInstance().getD();
             }
         });

         thread.start();
     }


 }
}

