package com.study.skyhuang.wanandroid.activity;

import com.study.skyhuang.wanandroid.base.BaseAbstractView;
import com.study.skyhuang.wanandroid.base.presenter.AbstractPresenter;

/**
 * Created by skyHuang on 2018/11/9.
 */

public interface SplashContract {

    interface View extends BaseAbstractView {
        void viewFun1();
    }

    interface Presenter extends AbstractPresenter<View> {
        void presenterFun1();
    }

}
