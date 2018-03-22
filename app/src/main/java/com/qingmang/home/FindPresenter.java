package com.qingmang.home;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.moudle.entity.Service;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class FindPresenter extends BaseMvpPresenter<FindView> {

    public void loadData(long id){
        addSubscribe(App.getInstance().getRetrofitServiceManager().create(ApiService.class).ServiceList(id)
                .compose(ResponseTransformer.<Service>handleResult())
                .compose(RxSchedulers.<Service>ObToMain())
                .subscribe(new Consumer<Service>() {
                    @Override
                    public void accept(Service service) throws Exception {
                        getMvpView().onDataSuccess(service);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));
    }

}
