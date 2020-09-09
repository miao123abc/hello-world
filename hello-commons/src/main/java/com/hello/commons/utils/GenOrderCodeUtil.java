package com.hello.commons.utils;

public class GenOrderCodeUtil {

    private static int num = 0;

    public String genOrderCode(){
        return String.valueOf(++num);
    }
}
