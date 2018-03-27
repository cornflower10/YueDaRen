package com.qingmang.serviceIntroduce;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.moudle.entity.Adress;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class AddressListPresenter extends BaseMvpPresenter<AddressListView> {


    public void addressList(){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class)
                .AddressList()
                .compose(ResponseTransformer.<List<Adress>>handleResult())
                .compose(RxSchedulers.<List<Adress>>ObToMain())
                .subscribe(new Consumer<List<Adress>>() {
                    @Override
                    public void accept(List<Adress> adressList) throws Exception {
                        getMvpView().onDataSuccess(adressList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

    public void setDefultAddress(int id){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class)
                .SetDefultAddress(Long.valueOf(id))
                .compose(ResponseTransformer.<Object>handleResult())
                .compose(RxSchedulers.<Object>ObToMain())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object s) throws Exception {
                        addressList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

    public void deleteAddress(int id){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class)
                .DeleteAddress(Long.valueOf(id))
                .compose(ResponseTransformer.<String>handleResult())
                .compose(RxSchedulers.<String>ObToMain())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        addressList();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

}
