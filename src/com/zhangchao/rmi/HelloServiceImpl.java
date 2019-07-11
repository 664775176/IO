package com.zhangchao.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:HelloServiceImpl
 * @description: TODO
 * @date 2019/5/27 11:14
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService{

    public HelloServiceImpl() throws RemoteException{
        super();
    }
    @Override
    public String sayHello(String someOne) throws RemoteException{
        return "hello " + someOne;
    }
}
