package com.zhangchao.jvm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ReorderExample {

	int a = 0;
	boolean flag = false;

	public void writer() {
	    a = 1;                //1
	    flag = true;          //2
	}
	
	public int reader() {
	    while (true) {        
	    	if (flag) {		//3
	    		int i =  a * a;	  //4
		        return i;
	    	}
	    }
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final ConcurrentMap<Integer,Integer> counter = new ConcurrentHashMap();
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			final ReorderExample re = new ReorderExample();
			
			Thread readThread = new Thread(new Runnable() {
				@Override
				public void run() {
					int result = re.reader();
					Integer count = counter.get(result);
					if (count == null) {
						count = 0;
					}
					counter.put(result, count.intValue() + 1);
				}
			});
			readThread.start();
			re.writer();
			readThread.join();
		}
		
		for (int result : counter.keySet()) {
			System.out.println("" + result + ","  + counter.get(result));
		}
		
	}

}