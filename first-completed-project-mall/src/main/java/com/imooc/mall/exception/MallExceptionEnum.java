package com.imooc.mall.exception;
public enum MallExceptionEnum {
    NEED_USER_NAME(10001,"用户名不能为空");
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
