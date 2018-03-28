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

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class AuthPresenter extends BaseMvpPresenter<AuthView> {

    private static final String TYPE_TEXT = "text/plain";
    private static final String TYPE_STREAM = "application/otcet-stream";

    public void updateInfo(String company,
                           String legal,
                           File file
    ){
        Map<String, RequestBody> params =new HashMap<>();
        if(!TextUtils.isEmpty(company))
            params.put("company",RequestBody.create(MediaType.parse(TYPE_TEXT),company));
        if(null!=file)
            params.put("file",RequestBody.create(MediaType.parse(TYPE_STREAM),file));
        if(!TextUtils.isEmpty(legal))
            params.put("legal",RequestBody.create(MediaType.parse(TYPE_TEXT),legal));
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class).Authcompany(params)
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
