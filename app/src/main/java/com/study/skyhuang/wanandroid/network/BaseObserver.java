package com.study.skyhuang.wanandroid.network;

import com.study.skyhuang.wanandroid.base.BaseAbstractView;

import io.reactivex.observers.ResourceObserver;

/**
 * Created by skyHuang on 2018/11/7.
 * 实现观察者接口的基类
 */

public abstract class BaseObserver<T> extends ResourceObserver<T> {
    private BaseAbstractView mView;
    private String errorMsg;
    private boolean isShowError = true;

    public BaseObserver(BaseAbstractView view) {
        this.mView = view;
    }

    public BaseObserver(BaseAbstractView view, String errorMsg) {
        this.mView = view;
        this.errorMsg = errorMsg;
    }

    public BaseObserver(BaseAbstractView view, String errorMsg, boolean isShowError) {
        this.mView = view;
        this.errorMsg = errorMsg;
        this.isShowError = isShowError;
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}
