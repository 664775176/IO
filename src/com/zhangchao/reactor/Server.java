package com.zhangchao.reactor;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:Server
 * @description: TODO
 * @date 2019/4/16 15:55
 */
public class Server {
    Selector selector = new Selector();
    Dispatcher eventLooper = new Dispatcher(selector);
    Acceptor acceptor;
    Server(int port){
        acceptor = new Acceptor(port, selector);
    }

    public void start(){
        eventLooper.registerEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        eventLooper.registerEventHandler(EventType.READ, new ReaderEventHandler(selector));
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();

    }

    public static void  main(String[] args){
        Server server = new Server(8080);
        server.acceptor.addNewConnection(new InputSource("test", 1L));
        server.start();
    }
}
