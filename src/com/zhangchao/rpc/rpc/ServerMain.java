package com.zhangchao.rpc.rpc;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ServerMain
 * @description: TODO
 * @date 2019/5/27 18:00
 */
public class ServerMain {
    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        ProviderReflect.provider(helloService, 8081);
    }
}
