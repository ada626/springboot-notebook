package com.imooc.mall.exception;

public enum MallExceptionEnum {
    NEED_USER_NAME(10001,"用户名不能为空"),
    NEED_PASSWORD(10002,"密码不能为空"),
    PASSWORD_NOT_QUALIFIED(10003,"密码不够长"),
    USERNAME_EXISTED(10004,"用户名已存在"),
    INSERT_FAILED(10005,"插入失败，请重试"),
    WRONG_PASSWORD(10006,"密码错误，请重试"),
    SYSTEM_ERROR(20000,"系统异常");

    /*
    异常码
     */
    Integer code;
    /*
    异常信息
     */
    String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    MallExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
