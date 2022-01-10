package com.imooc.mall.exception;

public enum MallExceptionEnum {
    NEED_USER_NAME(10001,"用户名不能为空"),
    NEED_PASSWORD(10002,"密码不能为空"),
    PASSWORD_NOT_QUALIFIED(10003,"密码不够长"),
    NAME_EXISTED(10004,"不允许重名"),
    INSERT_FAILED(10005,"新增失败，请重试"),
    WRONG_PASSWORD(10006,"密码错误，请重试"),
    NEED_LOGIN(10007,"请登录"),
    UPDATE_FIAILED(10008,"请登录"),
    NEED_ADMIN(10009,"非管理员，拒绝访问"),
    PARA_ERROR(100010,"参数异常"),
    ID_EXIST(100011,"id已存在"),
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
