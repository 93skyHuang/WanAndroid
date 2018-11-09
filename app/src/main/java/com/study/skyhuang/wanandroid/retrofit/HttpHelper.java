package com.study.skyhuang.wanandroid.retrofit;

import com.study.skyhuang.wanandroid.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by skyHuang on 2018/11/5.
 */

public class HttpHelper {
    private static volatile HttpService httpService;
    private static volatile HttpHelper mInstance;
    private final static String BASE_URL = "http://www.wanandroid.com/";


    private static void initHttpHelper() {
        if (mInstance == null) {
            synchronized (HttpHelper.class) {
                if (mInstance == null) {
                    mInstance = new HttpHelper();
                }
            }
        }
    }

    private HttpHelper() {
        init();
    }

    private void init() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient().newBuilder();
        //设置请求读写的超时时间
        okHttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {//logi拦截器
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(interceptor);
        }
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        httpService = retrofit.create(HttpService.class);


    }

    public static HttpService getHttpService() {
        initHttpHelper();
        return httpService;
    }
}
