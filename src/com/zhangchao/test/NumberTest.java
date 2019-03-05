package com.zhangchao.test;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:NumberTest
 * @description: TODO
 * @date 2018/12/19 14:44
 */
public class NumberTest {

    public static void main(String args[]){
        Integer i = 10;
        i = new Integer(11);
        fun1(i);
        System.out.println(i);

        User u = new User();
        u.setName("aa");
        fun2(u);
        System.out.println(u.getName());
    }
    public static void fun1(Integer i ){
        i = 9;
        System.out.println(i);
    }

    public static void fun2(final User u){
        u.setName("b");
        System.out.println(u.getName());
    }

}
class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

