package com.hello.demo.entity;

public enum CodeEnum {

    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(600, "请求成功"),
    TOKEN_OVERDUE(601,"token过期"),
    USER_NOT_EXIST(602,"用户未登录哦"),
    COMMON_ERROR(603,"系统繁忙，请稍后重试"),
    SERVER_ERROR(703, "服务器正在升级维护中，请稍后再试"),
//    USER_NOT_EXIST(701, "用户不存在"),
//    DATA_IS_NULL(703, "数据为空"),
//    DATA_IS_ERROR(704, "数据不合法，请检查！！")
    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
