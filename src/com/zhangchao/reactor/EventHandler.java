package com.zhangchao.reactor;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:EventHandler
 * @description: TODO
 * @date 2019/3/15 13:16
 */
public abstract class EventHandler {

    private InputSource inputSource;

    public InputSource getInputSource() {
        return inputSource;
    }

    public void setInputSource(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public abstract void handle(Event event);
}
