package com.hello.demo.util;

public class GenOrderCodeUtil {

    private static int num = 0;

    public String genOrderCode(){
        return String.valueOf(++num);
    }
}
