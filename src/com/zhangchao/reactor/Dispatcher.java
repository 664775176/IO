package com.zhangchao.reactor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Dispatcher
 * @description: reactor模式中Dispatcher类，负责event的分发和eventHandler的维护
 * @date 2019/3/15 13:25
 */
public class Dispatcher {
    //通过ConcurrentHashMap来维护不同事件处理器
    private Map<EventType, EventHandler> eventHandlerMap = new ConcurrentHashMap<>();;
    //本例只维护一个seletor负责事件选择，netty为了保证性能实现了多个seletor来保证循环处理性能，
    //不同事件加入不同的seletor的事件缓存队列
    private Selector selector;
    public Dispatcher(){
    }

    public Dispatcher(Selector selector){
        this.selector = selector;
    }
    //在Dispatcher中注册eventHandler
    public void registerEventHandler(EventType eventType, EventHandler eventHandler){
        eventHandlerMap.put(eventType, eventHandler);
    }

    public void removeEventHandler(EventType eventType){
        eventHandlerMap.remove(eventType);
    }

    public void handleEvents(){
        dispatch();
    }
    //此例只是实现了简单的事件分发给响应的处理器处理，例子中的处理器都是同步的，
    //在reactor模式的典型实现NIO中都是在handler异步处理，来保证非阻塞。
    private void dispatch(){
        while (true){
            List<Event> eventList = selector.select();
            for(Event event: eventList){
                EventHandler eventHandler = eventHandlerMap.get(event.getEventType());
                eventHandler.handle(event);
            }
        }
    }
}
