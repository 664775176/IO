package com.zhangchao.rpc.rpc;

import com.zhangchao.proxy.Hello;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ConsumerProxy
 * @description: TODO
 * @date 2019/5/27 16:41
 */
public class ConsumerProxy {
    public  static <T> T consumer(final Class<T> interfaceClass, final String host, final int port ) throws Exception{
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class<?>[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = null;
                ObjectOutputStream output = null;
                ObjectInputStream inputStream = null;
                Object result = null;
                try {
                    socket = new Socket(host, port);
                    output = new ObjectOutputStream(socket.getOutputStream());
                    output.writeUTF(method.getName());
                    output.writeObject(args);
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    result = inputStream.readObject();
                    if (result instanceof Throwable) {
                        throw (Throwable) result;
                    }

                } catch (Exception e) {
                } finally {
                    if (output != null) {
                        output.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                }
                return result;
            }
        });
    }
}
