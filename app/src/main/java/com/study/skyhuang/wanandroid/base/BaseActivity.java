package com.study.skyhuang.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.study.skyhuang.wanandroid.base.presenter.BasePresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by skyHuang on 2018/10/24.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseAbstractView {

    protected T mPresenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    protected abstract @LayoutRes
    int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.detachView();
    }

    @Override
    public void showErrorMsg(String errorMsg) {

    }
}
