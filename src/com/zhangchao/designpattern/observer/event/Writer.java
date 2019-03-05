package com.zhangchao.designpattern.observer.event;

import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Writer
 * @description: TODO
 * @date 2018/11/15 20:30
 */
public class Writer {
    private String name;

    public String getName() {
        return name;
    }

    public String getLastNovel() {
        return lastNovel;
    }

    public void setLastNovel(String lastNovel) {
        this.lastNovel = lastNovel;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String lastNovel;

    private Set<WriterListener> writerListenerSet = new HashSet<WriterListener>();

    public Writer(String name) {
        super();
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    public void addNovel(String novel) {
        System.out.println(name + "发布了新书《" + novel + "》！");
        lastNovel = novel;
        fireEvent();
    }

    public void fireEvent(){
        WriteEvent event = new WriteEvent(this);
        for(WriterListener writerListener : writerListenerSet) {
            writerListener.addNovel(event);
        }
    }

    //提供给外部注册成为自己的监听器的方法
    public void registerListener(WriterListener writerListener){
        writerListenerSet.add(writerListener);
    }
    //提供给外部注销的方法
    public void unregisterListener(WriterListener writerListener){
        writerListenerSet.remove(writerListener);
    }

}
