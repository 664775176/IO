package com.zhangchao.IO1;

import java.nio.ByteBuffer;

public class BufferTest {
    public static void main(String args[]) {
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("--------allocate-----------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.put("abcd".getBytes());
        System.out.println("-------------put--------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.flip();
        System.out.println("------------flip--------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("---------------get-----------");
        byte []bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("-------------rewind-------------");
        buffer.rewind();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        byte[] bytes2 = new byte[buffer.limit()];
        buffer.get(bytes2);
                 System.out.println(new String(bytes2, 0, bytes2.length));
                 System.out.println(buffer.position());
                 System.out.println(buffer.limit());
                 System.out.println(buffer.capacity());

         System.out.println("---------clear-----------");
         buffer.clear();
         System.out.println(buffer.position());
         System.out.println(buffer.limit());
         System.out.println(buffer.capacity());

         byte []bytes3 = new byte[10];
         buffer.get(bytes3);
         System.out.println(new String(bytes3, 0, bytes3.length));

        //buffer.reset();

    }
}
