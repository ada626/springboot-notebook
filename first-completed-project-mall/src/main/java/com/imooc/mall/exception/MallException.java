package com.imooc.mall.exception;

public class MallException extends Exception{
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private final Integer code;
    private final String message;

    public MallException(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    public MallException(MallExceptionEnum exceptionEnum){
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }
}
