package com.zhangchao.designpattern.decorator;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Decorator
 * @description: TODO
 * @date 2018/11/15 10:57
 *
 * 类比IO里面FilterInputStream,标准装饰器样板
 */
public class Decorator implements Component {
    protected  Component component;

    public Decorator(Component component) {
        super();
        this.component = component;
    }

    public void method(){
        component.method();
    }
}
