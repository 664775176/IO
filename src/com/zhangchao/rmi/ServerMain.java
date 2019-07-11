package com.zhangchao.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ServerMain
 * @description: TODO
 * @date 2019/5/27 11:17
 */
public class ServerMain {
    public static void main(String args[]) throws Exception{
        //创建服务
        HelloService service = new HelloServiceImpl();
        //注册服务
        LocateRegistry.createRegistry(8081);
        Naming.bind("rmi://localhost:8081/helloService",service);
        System.out.println("Server provide RMI service Now");
    }
}
