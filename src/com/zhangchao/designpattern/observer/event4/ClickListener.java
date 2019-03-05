package com.zhangchao.designpattern.observer.event4;

import java.util.EventListener;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ClientListenner
 * @description: TODO
 * @date 2018/11/16 14:54
 */
public interface ClickListener extends EventListener {

    public void click(ClickEvent event);
}

 interface DbClickListener extends EventListener {

    public void dbClick(DbClickEvent dbClickEvent);
}
interface MouseMoveListener extends EventListener {

    public void move(MouseMoveEvent mouseMoveEvent);
}

