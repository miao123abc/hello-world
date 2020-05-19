package com.hello.hello.dailyTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class aaa {
    public static void main(String[] args) throws IOException {
        char a = '一';//a='汗权';
        System.out.println("a = " + a);
//        System.out.println("输入一个字符!");
//        while (true){
//            a = (char) System.in.read();
//            System.out.println(a);
//        }

        String aa = "2.第一课";
        String bb = "1.第5课";
        String cc = "12.第二课";
        String[] strings = {aa, bb, cc};
        System.out.println("strings = " + Arrays.toString(strings));
        List<String> collect = Arrays.stream(strings).sorted(
                Comparator.comparingInt(o -> Integer.parseInt(o.substring(0, o.indexOf(".")))))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}