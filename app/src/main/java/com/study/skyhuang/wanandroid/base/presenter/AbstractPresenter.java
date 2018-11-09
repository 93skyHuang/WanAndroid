package com.study.skyhuang.wanandroid.base.presenter;

import com.study.skyhuang.wanandroid.base.BaseAbstractView;

/**
 * Created by skyHuang on 2018/11/7.
 */

public interface AbstractPresenter<T extends BaseAbstractView> {

    /**
     * 绑定view
     * @param view
     */
    void attachView(T view);

    /**
     * 解除view的绑定
     */
    void detachView();
}
