package com.zhangchao.designpattern.observer.event;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:WriterManager
 * @description: TODO
 * @date 2018/11/15 19:45
 */
public class WriterManager {

    private Map<String, Writer> map= new HashMap<>();

    public void add(Writer writer) {
        map.put(writer.getName(), writer);
    }

    public void remove(Writer writer) {
        map.remove(writer.getName());
    }

    public Writer getWriter(String name){
        return map.get(name);
    }
    //使用单例
    private WriterManager(){

    }
    public static WriterManager getInstance(){
        return WriterManagerInstance.writerManager;
    }

    private static class WriterManagerInstance {
        private static WriterManager writerManager = new WriterManager();
    }
}
