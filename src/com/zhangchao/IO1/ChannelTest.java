package com.zhangchao.IO1;

import jdk.management.resource.internal.inst.FileChannelImplRMHooks;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelTest {
    public static void main(String args[]) throws  Exception{
        FileInputStream fileInputStream = new FileInputStream("utf.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("data.txt");

        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1);
        int i=0;

        while(inChannel.read(buffer) != -1){
            buffer.flip();
            i++;
            byte[] bytes = new byte[1];
            buffer.get(bytes);
            System.out.println(i+"contest：" + new String(bytes, "UTF-8"));
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        buffer.clear();
        inChannel.close();
        outChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
        testMemoryMappingFile();
        transfer();
        testGatherScatter();
    }

    public static void testMemoryMappingFile() throws Exception{
        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("utf.txt"), StandardOpenOption.READ);
        // 注意：StandardOpenOption.CREATE
        // 如果文件已经存在，直接覆盖，StandardOpenOption.CREATE_NEW,如果文件已经存在，就抛出异常。
        FileChannel outChannel = FileChannel.open(Paths.get("data.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        MappedByteBuffer inMappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, outChannel.size());

        byte []bytes = new byte[inMappedByteBuffer.limit()];
        inMappedByteBuffer.get(bytes);
        outMappedByteBuffer.get(bytes);

        inChannel.close();
        outChannel.close();
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }

    public static void transfer() throws Exception {
        FileChannel inFileChannel = FileChannel.open(Paths.get("utf.txt"), StandardOpenOption.READ);
        FileChannel outFileChannel = FileChannel.open(Paths.get("data.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        inFileChannel.transferTo(0, inFileChannel.size(), outFileChannel);
        outFileChannel.transferFrom(inFileChannel, 0, inFileChannel.size());
    }


    public static void testGatherScatter() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("utf.txt", "rw");
        // 获取通道
        FileChannel channel = randomAccessFile.getChannel();

        // 申请缓存空间
        ByteBuffer byteBuffer00 = ByteBuffer.allocate(128);
        ByteBuffer byteBuffer01 = ByteBuffer.allocate(1024);

        // 通过channel.read(ByteBuffer[] byteBuffers),将数据分散读取到byteBuffer00,byteBuffer01
        ByteBuffer[] byteBuffers = { byteBuffer00, byteBuffer01 };
        channel.read(byteBuffers);

        for (ByteBuffer byteBuffer : byteBuffers) {
            byteBuffer.flip();
        }

        System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit()));
        System.out.println("-----------------------------------------------------------");
        System.out.println(new String(byteBuffers[1].array(), 0, byteBuffers[1].limit()));

        // 聚集写入
        RandomAccessFile randomAccessFile2 = new RandomAccessFile("data.txt", "rw");
        // 1、获取管道
        FileChannel channel2 = randomAccessFile2.getChannel();

        // 2、通过管道将数据写入
        channel2.write(byteBuffers);

        channel2.close();
        channel.close();
}
}
