package com.zhangchao.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:HelloService
 * @description: TODO
 * @date 2019/5/27 11:12
 */
public interface HelloService extends Remote {
    String sayHello(String someOne) throws RemoteException;
}
