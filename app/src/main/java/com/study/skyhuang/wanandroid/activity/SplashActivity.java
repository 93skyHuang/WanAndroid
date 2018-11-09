package com.study.skyhuang.wanandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.study.skyhuang.wanandroid.R;
import com.study.skyhuang.wanandroid.base.BaseActivity;
import com.study.skyhuang.wanandroid.date.BannerBean;
import com.study.skyhuang.wanandroid.network.BaseObserver;
import com.study.skyhuang.wanandroid.retrofit.HttpHelper;
import com.study.skyhuang.wanandroid.utils.RxUtils;

/**
 * Created by skyHuang on 2018/11/7.
 */

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View {
    private static final String TAG = "SplashActivity";
    TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.btn).setOnClickListener(v -> {
            Log.i(TAG, "onCreate: click");
            RxUtils.rx(HttpHelper.getHttpService().getBanner(), new BaseObserver<BannerBean>(null) {
                @Override
                public void onNext(BannerBean bannerBean) {
                    Log.i(TAG, "onNext: bannerBean="+bannerBean);
                }
            });
        });
    }

    @Override
    public void viewFun1() {

    }
}
