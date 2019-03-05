package com.zhangchao.designpattern.observer.event4;

import java.util.EventObject;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ButtonEvent
 * @description: TODO
 * @date 2018/11/16 15:00
 */
public abstract class ButtonEvent extends EventObject {

    public ButtonEvent(Object source) {
        super(source);
    }
}
class ClickEvent extends ButtonEvent {
    public ClickEvent(Object source) {
        super(source);
    }
}

class DbClickEvent extends ButtonEvent {
    public DbClickEvent(Object source) {
        super(source);
    }
}

class MouseMoveEvent extends ButtonEvent {
    public MouseMoveEvent(Object source) {
        super(source);
    }
}
