package com.study.skyhuang.wanandroid.retrofit;

import com.study.skyhuang.wanandroid.date.ArticleListBean;
import com.study.skyhuang.wanandroid.date.BannerBean;
import com.study.skyhuang.wanandroid.date.BaseResponse;
import com.study.skyhuang.wanandroid.date.FriendUrlBean;
import com.study.skyhuang.wanandroid.date.HomeListBean;
import com.study.skyhuang.wanandroid.date.HotKeyBean;
import com.study.skyhuang.wanandroid.date.NaviDataBean;
import com.study.skyhuang.wanandroid.date.OneProjectListBean;
import com.study.skyhuang.wanandroid.date.ProjectTreeBean;
import com.study.skyhuang.wanandroid.date.TreeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by skyHuang on 2018/10/25.
 * 接口
 */

public interface HttpService {

    /**
     * http://www.wanandroid.com/article/list/0/json
     * 方法：GET
     * 参数：页码，拼接在连接中，从0开始。
     */

    @GET("/article/list/{page}/json")
    Observable<BaseResponse<HomeListBean>> getHomeList(@Path("page") int page);


    /**
     * 首页banner
     * http://www.wanandroid.com/banner/json
     * 方法：GET
     * 参数：无
     */
    @GET("banner/json")
    Observable<BannerBean> getBanner();

    /**
     * 常用网址
     * http://www.wanandroid.com/friend/json
     * 方法：GET
     * 参数：无
     */
    @GET("friend/json")
    Observable<FriendUrlBean> getFriendUrl();

    /**
     * 1.4 搜索热词 即目前搜索最多的关键词。
     * http://www.wanandroid.com//hotkey/json
     * 方法：GET
     * 参数：无
     */
    @GET("/hotkey/json")
    Observable<HotKeyBean> getHotKey();

    /**
     * 2.1 体系数据
     * http://www.wanandroid.com/tree/json
     * 方法：GET
     * 参数：无
     */
    @GET("/tree/json")
    Observable<TreeBean> getTree();

    /*2.2 知识体系下的文章
     *http://www.wanandroid.com/article/list/0/json?cid=60
     *   方法：GET
     *   参数：
     *   cid 分类的id，上述二级目录的id
     *   页码：拼接在链接上，从0开始。
     * */
    @GET("article/list/{page}/json")
    Observable<ArticleListBean> getArticleList(@Path("page") int page, @Query("cid") int cid);


    /**
     * 3. 导航
     * 3.1 导航数据
     * http://www.wanandroid.com/navi/json
     * 方法：GET
     * 参数：无
     */
    @GET("navi/json")
    Observable<BaseResponse<NaviDataBean>> getNaviData();

    /*
    * 4. 项目
    *4.1 项目分类
    *http://www.wanandroid.com/project/tree/json
    *方法： GET
    *参数： 无
    */
    @GET("project/tree/json")
    Observable<ProjectTreeBean> getProjectTree();

    /**
     * 4.2 项目列表数据
     * 某一个分类下项目列表数据，分页展示
     * http://www.wanandroid.com/project/list/1/json?cid=294
     * 方法：GET
     * 参数：
     * cid 分类的id，上面项目分类接口
     * 页码：拼接在链接中，从1开始。
     */
    @GET("project/list/{page}/json")
    Observable<OneProjectListBean> getOneProjectList(@Path("page") int page, @Query("cid") int cid);

    /**
     * 5. 登录与注册
     * 5.1 登录
     * http://www.wanandroid.com/user/login
     * 方法：POST
     * 参数：
     * username，password
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponse> login(@Field("username") String username, @Field("password") String password);

    /**
     * 5.2 注册
     * http://www.wanandroid.com/user/register
     * 方法：POST
     * 参数
     * username,password,repassword
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponse> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 5.3 退出
     * http://www.wanandroid.com/user/logout/json
     * 方法：GET
     */
    @GET("logout/json")
    Observable<BannerBean> logout();

}
