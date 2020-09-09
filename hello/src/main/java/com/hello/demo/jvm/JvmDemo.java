package com.hello.demo.jvm;

import java.util.Random;

public class JvmDemo {

    public static void main(String[] args) {
//        printJvmDetail();

//        byte[] bytes = new byte[20 * 1024 * 1024];

        //OOM 对应jvm参数设置 -Xms10M -Xmx10M -XX:+PrintGCDetails（打印GC信息）
        String str = "www";
        while (true){
            str += str + new Random().nextInt(88888) + new Random().nextInt(99999);
        }
    }

    private static void printJvmDetail(){
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("本机逻辑处理器数量：" + availableProcessors);
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("(-Xmx:最大jvm内存，默认物理内存的1/4)--maxMemory：" + maxMemory + "字节，" + maxMemory / 1024 / 1024 + "MB");
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("(-Xms:初始内存，默认物理内存的1/64)--totalMemory：" + totalMemory + "字节，" + totalMemory / 1024 / 1024 + "MB");
        //运行操作系统进程
//        try {
//            Runtime.getRuntime().exec("D:\\workSoft\\finalshell\\finalshell.exe");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
