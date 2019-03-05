package com.zhangchao.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Reader
 * @description: TODO
 * @date 2018/11/15 19:42
 */
public class Reader implements Observer {

    private  String name;

    public Reader(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Writer) {
            Writer writer = (Writer) o;
            System.out.println(name+"知道" + writer.getName() + "发布了新书《" + writer.getLastNovel() + "》，非要去看！");
        }
    }

    public void subscribe(String writerName) {
        WriterManager.getInstance().getWriter(writerName).addObserver(this);
    }

    public void unSubscribe(String writerName) {
        WriterManager.getInstance().getWriter(writerName).deleteObserver(this);
    }
}
