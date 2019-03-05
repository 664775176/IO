package com.zhangchao.designpattern.observer.event3;

import java.util.Observable;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Writer
 * @description: TODO
 * @date 2018/11/16 13:49
 */
public class Writer extends Observable {

    private String name;
    private String lastNovel;

    public Writer(String name) {
        super();
        this.name = name;
        WriterManager.getInstance().addWriter(this);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNovel() {
        return lastNovel;
    }

    public void setLastNovel(String lastNovel) {
        this.lastNovel = lastNovel;
    }

    public void addNovel(String novelName) {
        System.out.println(name + "发布新书" + novelName);
        lastNovel = novelName;
        setChanged();
        notifyObservers();
    }
}
