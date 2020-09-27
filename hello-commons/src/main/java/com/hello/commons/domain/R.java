/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.hello.commons.domain;

/**
 * 返回数据
 */
public class R<T> {

    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回友好信息
     */
    private String msg;
    /**
     * 返回的具体数据
     */
    private T data;

    public R() {
    }

    public static <T> R<T> ok() {
        R<T> r = new R<>();
        r.setCode(CodeEnum.SUCCESS.getCode()).setMsg(CodeEnum.SUCCESS.getMsg());
        return r;
    }

    public static <T> R ok(T data) {
        R<T> r = ok();
        r.setData(data);
        return r;
    }

    public static R error() {
        return error(CodeEnum.BASIC_EXCEPTION.getCode(), CodeEnum.BASIC_EXCEPTION.getMsg());
    }

    public static R error(String msg) {
        return error(CodeEnum.BASIC_EXCEPTION.getCode(), msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.setCode(code).setMsg(msg);
        return r;
    }

    public Integer getCode() {
        return code;
    }

    public R setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public R setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    /**
     * 利用fastjson 做转换 解析结果类型
     */
//    public T getData(TypeReference<T> typeReference) {
//        Object data = getData();
//        String s = JSON.toJSONString(data);
//        return JSON.parseObject(s, typeReference);
//    }
    public R setData(T data) {
        this.data = data;
        return this;
    }

}
