package com.zhangchao.rpc.rpc;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ClientMain
 * @description: TODO
 * @date 2019/5/27 18:01
 */
public class ClientMain {
    public static void main(String[] args) throws Exception {
        HelloService helloService = ConsumerProxy.consumer(HelloService.class, "localhost", 8081);
//        for(int i = 0 ;i<10; i++){
            String hello = helloService.sayHello("charsel");
            System.out.println(hello);
//        }
    }
}
