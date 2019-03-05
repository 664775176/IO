package com.zhangchao.designpattern.observer.event3;

import java.util.*;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:WriterManager
 * @description: TODO
 * @date 2018/11/16 13:45
 */
public class WriterManager {
    private WriterManager(){}

    private Map<String, Writer> map = new HashMap<String, Writer>();

    public Writer getWriter(String writerName){
        return map.get(writerName);
    }

    public void addWriter(Writer writer) {
        map.put(writer.getName(), writer);
    }

    public static WriterManager getInstance(){
        return WriterManagerInstance.writerManager;
    }

    private static class WriterManagerInstance{
        private static WriterManager writerManager = new WriterManager();
    }
}
