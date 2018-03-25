package com.qingmang.api;


import com.qingmang.moudle.entity.Banner;
import com.qingmang.moudle.entity.BaseEntity;
import com.qingmang.moudle.entity.CustomerInfo;
import com.qingmang.moudle.entity.HotMessage;
import com.qingmang.moudle.entity.Order;
import com.qingmang.moudle.entity.Service;
import com.qingmang.moudle.entity.ServiceInfo;
import com.qingmang.moudle.entity.VenService;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by xiejingbao on 2017/5/18.
 */

public interface ApiService {

    /**
     * sms
     * @param mobile
     * @return
     */
    @FormUrlEncoded
    @POST("customer/regist/sms")
    Observable<BaseEntity<String>> GetSms(@Field("mobile") String mobile);

    /**
     *
     *
     * @return
     */
    @FormUrlEncoded
    @POST("customer/regist")
    Observable<BaseEntity<String>> Register(@Field("name") String name,
                                          @Field("mobile") String mobile,
                                          @Field("password") String password,
                                          @Field("code") String code);

    /**
     * 登录
     * @param mobile
     * @param passWd
     * @return
     */
    @FormUrlEncoded
    @POST("customer/login")
    Observable<BaseEntity<String>> Login(@Field("mobile") String mobile,
                                              @Field("password") String passWd);
    @GET("customer/info")
    Observable<BaseEntity<CustomerInfo>> CusomerInfo();

    @FormUrlEncoded
    @POST("customer/upwd/sms")
    Observable<BaseEntity<String>> UpdatePasswdSms(@Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("customer/upwd")
    Observable<BaseEntity<String>> UpdatePasswd(@Field("mobile") String mobile,
                                                @Field("pwd") String pwd,
                                                @Field("code") String code);




    /**
     * 首页banner
     * @return
     */
    @GET("article/top")
    Observable<BaseEntity<Banner>> topBanner();
    /**
     * 中间banner
     * @return
     */
    @GET("article/mid")
    Observable<BaseEntity<Banner>> MindBanner();


    /**
     * 热点服务
     * @return
     */
    @GET("goods/top")
    Observable<BaseEntity<Service>> HotService();

    /**
     * 热点资讯
     * @return
     */
    @GET("article/hot")
    Observable<BaseEntity<HotMessage>> HotMessages();


    /**
     * 市民banner
     * @return
     */
    @GET("article/pbl")
    Observable<BaseEntity<Banner>> ServiveBanner();
    /**
     * 市民服务列表
     * @return
     */
    @GET("goods/list/citizen")
    Observable<BaseEntity<VenService>> VentureServices();

    /**
     * 服务详情
     * @return
     */
    @FormUrlEncoded
    @POST("goods/detail")
    Observable<BaseEntity<ServiceInfo>> ServiceDetail(@Field("id") long id);



    @FormUrlEncoded
    @POST("orders/list")
    Observable<BaseEntity<Order>> OrderList(@Field("pageNumber") int page,
                                            @Field("pageSize") int size,
                                            @Field("type") String type,
                                            @Field("step") String step);
    @FormUrlEncoded
    @POST("orders/list")
    Observable<BaseEntity<Order>> OrderList(@Field("pageNumber") int page,
                                            @Field("pageSize") int size);

    /**
     *
        创业服务列表查询接口
     * @return
     */
    @FormUrlEncoded
    @POST("goods/list/job")
    Observable<BaseEntity<Service>> ServiceList(@Field("cateid") long id);


}
