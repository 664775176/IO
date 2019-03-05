package com.zhangchao.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Observable
 * @description: TODO
 * @date 2018/11/15 19:28
 */
public class Observable {
    private List<Observer> observerList = new ArrayList<Observer>();

    public void addObserver(Observer o) {
        observerList.add(o);
    }

    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    public void modifyObserver(){
        for(Observer o: observerList) {
            o.update(this);
        }
    }
}
