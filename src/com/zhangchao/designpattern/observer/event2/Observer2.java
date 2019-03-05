package com.zhangchao.designpattern.observer.event2;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Observer1
 * @description: TODO
 * @date 2018/11/16 13:19
 */
public class Observer2 implements  Observer {

    @Override
    public void update(Observable o) {
        System.out.println("Observer2做出update" + o);

    }
}
