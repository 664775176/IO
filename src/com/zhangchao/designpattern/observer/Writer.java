package com.zhangchao.designpattern.observer;

import java.util.Observable;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Writer
 * @description: TODO
 * @date 2018/11/15 19:47
 */
public class Writer extends Observable {

    private String name;
    private String lastNovel;  //记录作者最新发布的小说
    public String getName() {
        return name;
    }

    public String getLastNovel() {
        return lastNovel;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setLastNovel(String lastNovel) {
        this.lastNovel = lastNovel;
    }

    public Writer(String name) {
        super();
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    public void addNovel(String novelName) {
        System.out.println(name + "发布了新书" + novelName);
        lastNovel = name;
        setChanged();
        notifyObservers();
    }

}
