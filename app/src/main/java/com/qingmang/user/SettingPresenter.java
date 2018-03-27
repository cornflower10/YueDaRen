package com.qingmang.user;

import android.text.TextUtils;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static android.text.style.TtsSpan.TYPE_TEXT;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class SettingPresenter extends BaseMvpPresenter<ForgetPasswdView> {

    public void updateInfo(String name,
                           File file,
                           String province,
                           String city,
                           String district,
                           String address,
                           String realname,
                           String idcard
                           ){
        Map<String, RequestBody> params =new HashMap<>();
        if(!TextUtils.isEmpty(name))
        params.put("name",RequestBody.create(MediaType.parse(TYPE_TEXT),name));
        params.put("file",RequestBody.create(MediaType.parse(TYPE_STREAM),file));
        if(!TextUtils.isEmpty(province))
        params.put("province",RequestBody.create(MediaType.parse(TYPE_TEXT),province));
        if(!TextUtils.isEmpty(city))
        params.put("city",RequestBody.create(MediaType.parse(TYPE_TEXT),city));
        if(!TextUtils.isEmpty(district))
        params.put("district",RequestBody.create(MediaType.parse(TYPE_TEXT),district));
        if(!TextUtils.isEmpty(address))
        params.put("address",RequestBody.create(MediaType.parse(TYPE_TEXT),address));
        if(!TextUtils.isEmpty(realname))
        params.put("realname",RequestBody.create(MediaType.parse(TYPE_TEXT),realname));
        if(!TextUtils.isEmpty(idcard))
        params.put("idcard",RequestBody.create(MediaType.parse(TYPE_TEXT),idcard));
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class).UpdateCustomer(params)
                .compose(ResponseTransformer.<String>handleResult())
                .compose(RxSchedulers.<String>ObToMain())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String sms) throws Exception {
                            getMvpView().onDataSuccess(sms);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

}
