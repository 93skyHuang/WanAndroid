package com.study.skyhuang.wanandroid.date;


/**
 * Created by skyHuang on 2018/11/5.
 * 所有数据的基类
 */

public abstract class BaseResponse<T> {


    /**
     * data : []
     * errorCode : 0
     * errorMsg :
     */

    private int errorCode;
    private String errorMsg;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
