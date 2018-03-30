package com.qingmang.user;

import android.text.TextUtils;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import java.io.File;

import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class AuthPresenter extends BaseMvpPresenter<AuthView> {


    public void updateInfo(String company,
                           String legal,
                           File file
    ){


        RequestBody requestFile =
                RequestBody.create(MediaType.parse("application/otcet-stream"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("file", file.getName(), requestFile);



        RequestBody companyRequest = null,legalRequest= null;

        if(!TextUtils.isEmpty(company)){
            companyRequest =
                    RequestBody.create(
                            MediaType.parse("multipart/form-data"), company);
        }

        if(!TextUtils.isEmpty(legal)){
            legalRequest =
                    RequestBody.create(
                            MediaType.parse("multipart/form-data"), legal);
        }

        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class).Authcompany2(companyRequest,body,legalRequest)
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
