package com.study.skyhuang.wanandroid.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by skyHuang on 2018/10/25.
 *
 */

public interface RetrofitService {

        @GET("/article/list/{page}/json")
        Call<List> getHomeList(@Path("page") int page);

}
