package com.zhangchao.reactor;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Selector
 * @description: TODO
 * @date 2019/3/15 13:51
 */
public class Selector {
    private BlockingQueue<Event> queue = new LinkedBlockingDeque<>();
    private Object lock = new Object();

    public List<Event>  select(){
       return select(0);
    }
    public List<Event> select(long timeout){
        return null;
    }

}
