package com.study.skyhuang.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by skyHuang on 2018/10/24.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected T presenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);

    }

    protected abstract @LayoutRes int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
