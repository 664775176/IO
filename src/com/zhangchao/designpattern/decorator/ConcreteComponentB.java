package com.zhangchao.designpattern.decorator;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ConcreteComponentA
 * @description: TODO
 * @date 2018/11/15 11:00
 */
public class ConcreteComponentB extends  Decorator implements Component{

    public ConcreteComponentB(Component component) {
        super(component);
    }

    public void methodB() {
        System.out.println("被装饰器B扩展功能");
    }

    public void method(){
        System.out.println("针对方法增加一层B包装");
        super.method();
        System.out.println("B结束包装");
    }
}
