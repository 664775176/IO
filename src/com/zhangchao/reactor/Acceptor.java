package com.zhangchao.reactor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Acceptor
 * @description: TODO
 * @date 2019/4/16 15:47
 */
public class Acceptor implements Runnable {
    private int port;
    private Selector selector;

    private BlockingQueue<InputSource> sourceQueue = new LinkedBlockingQueue<>();

    Acceptor(int port, Selector selector){
        this.port = port;
        this.selector = selector;
    }
    public int getPort(){
        return this.port;
    }
    //外部有输入请求后，需要加入到请求队列中
    public void addNewConnection(InputSource inputSource){
        sourceQueue.offer(inputSource);
    }

    public void run(){
        while(true) {
            InputSource source = null;
            try {
                // 相当于 serversocket.accept()，接收输入请求，该例从请求队列中获取输入请
                source = sourceQueue.take();
            } catch (InterruptedException e){
                //ignore
            }
            if(source != null){
                //接收到InputSource后将接收到event设置type为ACCEPT，并将source赋值给event
                Event acceptEvent = new Event();
                acceptEvent.setInputSource(source);
                acceptEvent.setEventType(EventType.ACCEPT);
                selector.addEvent(acceptEvent);
            }
        }
    }
}
