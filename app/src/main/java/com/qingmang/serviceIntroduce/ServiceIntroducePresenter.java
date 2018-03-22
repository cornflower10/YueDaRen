package com.qingmang.serviceIntroduce;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.moudle.entity.VenService;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class ServiceIntroducePresenter extends BaseMvpPresenter<ServiceIntroduceView> {

    public void loadData(){
        addSubscribe(App.getInstance().getRetrofitServiceManager().create(ApiService.class).VentureServices()
                .compose(ResponseTransformer.<VenService>handleResult())
                .compose(RxSchedulers.<VenService>ObToMain())
                .subscribe(new Consumer<VenService>() {
                    @Override
                    public void accept(VenService venServiceBaseEntity) throws Exception {
                            getMvpView().onDataSuccess(venServiceBaseEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

}
