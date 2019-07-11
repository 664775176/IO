package com.zhangchao.reactor;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:AcceptEventHandler
 * @description: TODO
 * @date 2019/4/16 14:50
 */
public class ReaderEventHandler extends EventHandler{

    private Selector selector;

    public ReaderEventHandler(Selector selector) {
        this.selector = selector;
    }

    public void handle(Event event) {
        //处理Accept的event事件
        if(EventType.READ.equals(event.getEventType())){
//            Event readEvent = new Event();
//            readEvent.setInputSource(event.getInputSource());
//            readEvent.setEventType(EventType.READ);
            System.out.println(event.getInputSource());
//            selector.addEvent(readEvent);
        }
    }
}
