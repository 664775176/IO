package com.zhangchao.designpattern.decorator;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ConcreteComponentA
 * @description: TODO
 * @date 2018/11/15 11:00
 */
public class ConcreteComponentA extends  Decorator implements Component {

    public ConcreteComponentA(Component component) {
        super(component);
    }

    public void methodA() {
        System.out.println("被装饰器A扩展功能");
    }

    public void method(){
        System.out.println("针对方法增加一层A包装");
        super.method();
        System.out.println("A结束包装");
    }
}
