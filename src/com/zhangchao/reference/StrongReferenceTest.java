package com.zhangchao.reference;

/**
 * @author Charsel zhang
 * @version 0.0.1
 * @classNane:StrongReferenceTest
 * @description: TODO
 * @date 2019/3/7 10:29
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
          Object[] elementData = new Object[10];
          for(int i=0; i< 10; i++){
              elementData[i] = 0;
          }
          Object [] list = elementData;
          elementData = null;   //这里将引用置为null也不会引起gc回收，
//            for(int i=0; i< 10; i++){
//                elementData[i] = null;   //这种方式会将所有数组内存回收，即使还有其他引用。这也是ArrayList clear的实现
//            }
            System.out.println(list.length + "：" + list[0]);
          System.gc();

    }
}
