package com.zhangchao.designpattern.observer;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Observer1
 * @description: TODO
 * @date 2018/11/15 19:33
 */
public class Observer1 implements Observer {

    @Override
    public void update(Observable o) {
        System.out.println("Observer1 update");
    }
}
