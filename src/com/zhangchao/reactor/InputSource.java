package com.zhangchao.reactor;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:InputSource
 * @description: 输入对象，reactor模式中处理对象
 * @date 2019/3/15 13:12
 */
public class InputSource {

    public InputSource(){

    }
    public InputSource(Object data, Long id){
        this.data = data;
        this.id = id;
    }
    private Object data;
    private Long id;

    public String toString(){
        return "InputSource{"+
                "data=" + data +
                ",id=" + id +
                "}";
    }
}
