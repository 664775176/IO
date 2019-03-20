package com.zhangchao.reactor;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Event
 * @description: TODO
 * @date 2019/3/15 13:12
 */
public class Event {
    public InputSource getInputSource() {
        return inputSource;
    }

    public void setInputSource(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    private InputSource inputSource;
    private EventType eventType;
}
