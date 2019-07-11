package com.zhangchao.rpc.rpc;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:HelloServiceImpl
 * @description: TODO
 * @date 2019/5/27 16:39
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String someOne) {
        return "hello " + someOne;
    }
}
