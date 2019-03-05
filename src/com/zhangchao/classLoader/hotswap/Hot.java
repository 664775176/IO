package com.zhangchao.classLoader.hotswap;

public class Hot {
public void hot() {
   System.out.println(" version 2 : " + this.getClass().getClassLoader());
    System.out.println("重新编译Class.......");
}
}