package com.zhangchao.designpattern.observer.event;

import java.util.EventListener;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:WriterListener
 * @description: TODO
 * @date 2018/11/15 20:32
 */
public interface WriterListener extends EventListener {

    public void addNovel(WriteEvent writeEvent);
}
