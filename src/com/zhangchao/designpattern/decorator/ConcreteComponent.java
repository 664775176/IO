package com.zhangchao.designpattern.decorator;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ConcreteComponent
 * @description: TODO
 * @date 2018/11/15 10:56
 *
 * 类比IO里面FileInputStream,待装饰的对象
 */
public class ConcreteComponent implements  Component {

    @Override
    public void method() {
        System.out.println("原来的方法");
    }
}
