package com.zhangchao.designpattern.observer.event2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Observable
 * @description: TODO
 * @date 2018/11/16 11:38
 */
public class Observable {
    private List<Observer> observerList = new ArrayList<>();

    private volatile boolean isUpdated = false;

    public synchronized boolean isUpdated() {
        return isUpdated;
    }

    public synchronized void setUpdated(boolean updated) {
        isUpdated = updated;
    }

    public synchronized void addObserver(Observer o) {
        observerList.add(o);
    }

    public synchronized void removeObserver(Observer o) {
        observerList.remove(o);
    }

    public  void modifyAllObserver(){
        if(!isUpdated) {
            return ;
        }
        synchronized (this)
        {
            for(Observer o: observerList) {
                o.update(this);
            }
        }
    }
}
