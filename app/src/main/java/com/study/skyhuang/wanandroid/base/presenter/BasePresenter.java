package com.study.skyhuang.wanandroid.base.presenter;

import com.study.skyhuang.wanandroid.base.BaseAbstractView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by skyHuang on 2018/10/24.
 *
 * mPresenter 的基类
 */

public class BasePresenter<T extends BaseAbstractView> implements AbstractPresenter<T>{

    private CompositeDisposable compositeDisposable;
    private T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }


    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

}
