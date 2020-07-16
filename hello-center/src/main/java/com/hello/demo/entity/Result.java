package com.hello.demo.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class Result {

    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回友好信息
     */
    private String message;
    /**
     * 返回的具体数据
     */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object object) {
        this.data = object;
        return this;
    }

    public Result() {
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 成功有数据返回
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(CodeEnum.SUCCESS.getCode())
                .setMessage(CodeEnum.SUCCESS.getMsg())
                .setData(object);
        return result;
    }

    /**
     * 成功无数据返回
     * @return
     */
    public static Result success() {
        return success(new ArrayList());
    }


    /***
     * 成功返回,带有info
     */
    public static Result successInfo(Object object) {
        Map<String,Object> map =new HashMap<>();
        map.put("info",object);
        return  success(map);
    }

    /**
     * 失败自定义信息
     * @param code
     * @param message
     * @return
     */
    public static Result error(Integer code, String message){
        Result result = new Result();
        result.setCode(code).setMessage(message).setData(new ArrayList());
        return result;
    }
}
