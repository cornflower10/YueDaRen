package com.qingmang.user;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class RegisterPresenter extends BaseMvpPresenter<RegisterView> {

    public void sendSms(String phone){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class).GetSms(phone)
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

    public void register(String name,String phone,String passwd,String code){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class).Register(name,phone,passwd,code)
                .compose(ResponseTransformer.<String>handleResult())
                .compose(RxSchedulers.<String>ObToMain())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String o) throws Exception {
                        getMvpView().onRegister(o);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

}
