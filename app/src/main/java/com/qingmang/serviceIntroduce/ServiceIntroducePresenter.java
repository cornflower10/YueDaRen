package com.qingmang.serviceIntroduce;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.moudle.entity.ServiceInfo;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class ServiceIntroducePresenter extends BaseMvpPresenter<ServiceIntroduceView> {

    public void loadData(long id){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class)
                .ServiceDetail(id)
                .compose(ResponseTransformer.<ServiceInfo>handleResult())
                .compose(RxSchedulers.<ServiceInfo>ObToMain())
                .subscribe(new Consumer<ServiceInfo>() {
                    @Override
                    public void accept(ServiceInfo serviceInfo) throws Exception {
                            getMvpView().onDataSuccess(serviceInfo);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

}
