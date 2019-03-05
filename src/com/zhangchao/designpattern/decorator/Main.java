package com.zhangchao.designpattern.decorator;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Main
 * @description: TODO
 * @date 2018/11/15 11:04
 */
public class Main {
    public static void main(String []args) {
        Component component = new ConcreteComponent();  //原来的对象
        System.out.println("---------------------");
        component.method();//原来的方法
        ConcreteComponentA concreteComponentA = new ConcreteComponentA(component);  //装饰成A
        System.out.println("---------------------");
        concreteComponentA.method(); //原来的方法
        concreteComponentA.methodA(); //装饰成A增强的方法
        ConcreteComponentB concreteComponentB = new ConcreteComponentB(component);  //装饰成A
        System.out.println("---------------------");
        concreteComponentB.method(); //原来的方法
        concreteComponentB.methodB(); //装饰成B增强的方法
        concreteComponentB = new ConcreteComponentB(concreteComponentA);  //装饰成A以后再装饰成B
        System.out.println("---------------------");
        concreteComponentB.method(); //原来的方法
        concreteComponentB.methodB(); //装饰成B增强的方法

    }
}
