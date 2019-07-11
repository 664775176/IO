package com.zhangchao.rpc.rpc;

import org.apache.commons.lang3.reflect.MethodUtils;
import sun.reflect.misc.MethodUtil;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:ProviderReflect
 * @description: TODO
 * @date 2019/5/27 16:53
 */
public class ProviderReflect {
    private static  final ExecutorService POOL = Executors.newCachedThreadPool();

    public static void provider(final Object service, int port)throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while(true) {
                try (final Socket socket = serverSocket.accept()){
                    POOL.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                try(ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())){
                                    String methodName = inputStream.readUTF();
                                    System.out.println(methodName);
                                    Object []arguments = (Object[])inputStream.readObject();
                                    Object object = MethodUtils.invokeExactMethod(service, methodName);
                                    try(ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())){
                                        outputStream.writeObject(object);
                                    }
                                }
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }
}
