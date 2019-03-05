package com.zhangchao.designpattern.observer;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Observer
 * @description: TODO
 * @date 2018/11/15 19:27
 */
//这个接口是为了提供一个统一的观察者做出相应行为的方法
public interface Observer {
    public void update(Observable o);
}
