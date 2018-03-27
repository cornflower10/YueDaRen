package com.qingmang.serviceIntroduce;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class AddAddressPresenter extends BaseMvpPresenter<AddAddressView> {

    public void addAddress(String collector,
                         String mobile,
                         String province,
                         String city,
                         String areas,
                         String address){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class)
                .AddAddress(collector,mobile,province,city,areas,address)
                .compose(ResponseTransformer.<String>handleResult())
                .compose(RxSchedulers.<String>ObToMain())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String str) throws Exception {
                            getMvpView().onDataSuccess(str);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

}
