package com.xzf.org.emall.utils;


import groovy.transform.CompileStatic;

@CompileStatic
public class Result<T>{

    T data;

    boolean success = true;

    String errMsg = "";

    public static<T> Result<T> of(T data){
        Result<T> result = new Result<>();
        result.data = data;
        result.success = true;
        return result;
    }

    public static <T> Result<T> addErr(String errorMsg){
        Result<T> result = new Result<>();
        result.errMsg = errorMsg;
        result.success = false;
        return result;
    }

    public static <T> Result<T> addErr(Exception e){
        Result<T> result = new Result<>();
        result.errMsg = e.getMessage();
        result.success = false;
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
