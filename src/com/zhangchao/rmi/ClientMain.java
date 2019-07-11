package com.zhangchao.rmi;

import java.rmi.Naming;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ClientMain
 * @description: TODO
 * @date 2019/5/27 11:21
 */
public class ClientMain {
    public static void main(String args[]) throws Exception{
        //服务引入
        HelloService service = (HelloService) Naming.lookup("rmi://localhost:8081/helloService");
        //调用远程方法
        System.out.println("RMI client result:" + service.sayHello("charsel"));

    }
}
