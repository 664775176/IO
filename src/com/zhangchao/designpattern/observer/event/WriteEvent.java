package com.zhangchao.designpattern.observer.event;

import java.util.EventObject;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:WriteEvent
 * @description: TODO
 * @date 2018/11/15 20:28
 */
public class WriteEvent extends EventObject {

    private static final long serialVersionUID = 8546459078247503692L;

    public WriteEvent(Writer writer) {
        super(writer);
    }
    public Writer getWriter() {
        return (Writer)super.getSource();
    }
}
