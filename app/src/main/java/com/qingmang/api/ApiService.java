package com.qingmang.api;


import com.qingmang.moudle.entity.Adress;
import com.qingmang.moudle.entity.Banner;
import com.qingmang.moudle.entity.BaseEntity;
import com.qingmang.moudle.entity.CustomerInfo;
import com.qingmang.moudle.entity.HotMessage;
import com.qingmang.moudle.entity.HotService;
import com.qingmang.moudle.entity.Order;
import com.qingmang.moudle.entity.Service;
import com.qingmang.moudle.entity.ServiceInfo;
import com.qingmang.moudle.entity.VenService;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

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
//
//      params.put("openAccountCatagory", RequestBody.create(MediaType.parse(TYPE_TEXT),customer.getOpenAccountCatagory()));
//       params.put("op
    //上传
    @Multipart
    @POST("customer/info/update")
    Observable<BaseEntity<String>> UpdateCustomer(@PartMap Map<String, RequestBody> params);
//   params.put("operatorIdentityImages"+"\";fileName=\""+file1.getName(),RequestBody.create(MediaType.parse(TYPE_STREAM), file1));


    @Multipart
    @POST("customer/authen")
    Observable<BaseEntity<String>> Authcompany(@PartMap Map<String, RequestBody> params);
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
    Observable<BaseEntity<List<HotService>>> HotService();

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


    /**
     * 下单
     * @param id
     * @param num
     * @param choose
     * @param chosecity
     * @param chosedistrict
     * @param addressid
     * @param invoicetype
     * @param invoiceraise
     * @param company
     * @param taxpayer
     * @return
     */
    @FormUrlEncoded
    @POST("orders/place")
    Observable<BaseEntity<String>> Order(@Field("goodsid") long id,
                                         @Field("num") int num,
                                         @Field("choose") String choose,
                                         @Field("chosecity") String chosecity,
                                         @Field("chosedistrict") String chosedistrict,
                                         @Field("addressid") long addressid,
                                         @Field("invoicetype") int invoicetype,
                                         @Field("invoiceraise") int invoiceraise,
                                         @Field("company") String company,
                                         @Field("taxpayer") String taxpayer
                                         );




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


    /**
     * 添加地址
     * @param collector
     * @param mobile
     * @param province
     * @param city
     * @param areas
     * @param address
     * @return
     */
    @FormUrlEncoded
    @POST("customer/address/add")
    Observable<BaseEntity<String>> AddAddress(@Field("collector") String collector,
                                         @Field("mobile") String mobile,
                                         @Field("province") String province,
                                         @Field("city") String city,
                                         @Field("areas") String areas,
                                         @Field("address") String address,
                                              @Field("top") int top
    );

    /**
     * 更新地址
     * @param collector
     * @param mobile
     * @param province
     * @param city
     * @param areas
     * @param address
     * @return
     */
    @FormUrlEncoded
    @POST("customer/address/update")
    Observable<BaseEntity<String>> UpdateAddress(@Field("id") String id,
                                                 @Field("collector") String collector,
                                              @Field("mobile") String mobile,
                                              @Field("province") String province,
                                              @Field("city") String city,
                                              @Field("areas") String areas,
                                              @Field("address") String address,
                                                 @Field("top") int top

    );


    @GET("customer/address/list")
    Observable<BaseEntity<List<Adress>>> AddressList();


    /**
     *
     设置默认收货地址
     * @return
     */
    @FormUrlEncoded
    @POST("customer/address/setdef")
    Observable<BaseEntity<Object>> SetDefultAddress(@Field("id") long id);
    /**
     *
     删除收货地址
     * @return
     */
    @FormUrlEncoded
    @POST("customer/address/delete")
    Observable<BaseEntity<String>> DeleteAddress(@Field("id") long id);
}
