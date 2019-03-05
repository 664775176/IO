package com.zhangchao.designpattern.observer.event3;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Reader
 * @description: TODO
 * @date 2018/11/16 13:53
 */
public class Reader implements Observer {
    public String getName() {
        return name;
    }

    public Reader(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void subcribe(String writerName){
        WriterManager.getInstance().getWriter(writerName).addObserver(this);
    }

    public void unSubcribe(String writerName) {
        WriterManager.getInstance().getWriter(writerName).deleteObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Writer) {
            Writer writer = (Writer)o;
            System.out.println(writer.getName()+"发布新书"+writer.getLastNovel() + "," + name +"非要看");
        }
    }
}
