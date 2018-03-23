package com.qingmang.api;


import com.qingmang.moudle.entity.Banner;
import com.qingmang.moudle.entity.BaseEntity;
import com.qingmang.moudle.entity.HotMessage;
import com.qingmang.moudle.entity.LoginEntity;
import com.qingmang.moudle.entity.Order;
import com.qingmang.moudle.entity.Service;
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
     * 注册
     * @param userName
     * @param type
     * @param sign
     * @return
     */
    @FormUrlEncoded
    @POST("regist.php")
    Observable<BaseEntity> getSms(@Field("mobile") String userName,
                                 @Field("mobileCodeType") String type,
                                 @Field("sign") String sign);

    /**
     * 登录
     * @param userName
     * @param passWd
     * @return
     */
    @FormUrlEncoded
    @POST("regist.php")
    Observable<BaseEntity<LoginEntity>> login(@Field("phone") String userName,
                                              @Field("password") String passWd
                                              );
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
     * 市民服务列表
     * @return
     */
    @GET("goods/list/citizen")
    Observable<BaseEntity<VenService>> VentureServices();



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






//
//
//
//    @FormUrlEncoded
//    @POST("agency/shuanglu/changePassword")
//    Observable<ChangePasswdEntity> changePasswd(@Field("oldPassword") String userName,
//                                                @Field("newPassword") String passWd,
//                                                @Field("sign") String sign
//    );
//
//    //上传同时
//    @Multipart
//    @POST("agency/shuanglu/submitIntentAgencyInfo")
//    Observable<UploadEntity> uploads(@PartMap Map<String, RequestBody> params
//    );
//
//    @FormUrlEncoded
//    @POST("agency/shuanglu/isAgencyNameUsed")
//    Observable<AgencyNameUsed> isAgencyNameUsed(@Field("customName") String customName,
//                                                @Field("sign") String sign);
}
