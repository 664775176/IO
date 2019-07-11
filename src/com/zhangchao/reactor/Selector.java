package com.zhangchao.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Selector
 * @description: reactor模式中Demultiplexer类，提供seletor()方法，用于从缓冲队列查找出符合条件的event列表
 * @date 2019/3/15 13:51
 */
public class Selector {
    //
    private BlockingQueue<Event> queue = new LinkedBlockingDeque<>();
    private Object lock = new Object();

    public List<Event>  select(){
       return select(0);
    }

    public List<Event> select(long timeout){
        if(timeout > 0){
            if(queue.isEmpty()){
                synchronized (lock) {
                    if(queue.isEmpty()){
                        try {
                            lock.wait(timeout);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }
        }
        // 例子中只是简单的将event列表全部返回，可以在此处增加业务逻辑，选出符合条件的event进行返回
        List<Event> events = new ArrayList<>();
        queue.drainTo(events);
        return events;
    }

    public void addEvent(Event e){
        //将event事件加入队列
        boolean success = queue.offer(e);
        if(success){
            synchronized (lock){
                //如果有新增事件则对lock对象解锁
                lock.notify();
            }
        }
    }

}
