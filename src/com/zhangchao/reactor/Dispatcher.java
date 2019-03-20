package com.zhangchao.reactor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Dispatcher
 * @description: TODO
 * @date 2019/3/15 13:25
 */
public class Dispatcher {

    private Map<Event, EventHandler> map;

    public Dispatcher(){
        this.map = new ConcurrentHashMap<>();
    }

    public Dispatcher(Map<Event, EventHandler> map){
        this.map = map;
    }
}
