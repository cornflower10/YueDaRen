package com.qingmang.home;

import android.text.TextUtils;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.moudle.entity.Order;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class OrderPresenter extends BaseMvpPresenter<OrderView> {

    public void loadData(int page,String type,String step){
        if(TextUtils.isEmpty(type)||TextUtils.isEmpty(step)){
            addSubscribe(App.getInstance().getRetrofitServiceManager()
                    .create(ApiService.class).OrderList(page,10)
                    .compose(ResponseTransformer.<Order>handleResult())
                    .compose(RxSchedulers.<Order>ObToMain())
                    .subscribe(new Consumer<Order>() {
                        @Override
                        public void accept(Order orderBaseEntity) throws Exception {
                            getMvpView().onDataSuccess(orderBaseEntity);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getMvpView().onError(throwable.getMessage());
                        }
                    }));

        }else {
            addSubscribe(App.getInstance().getRetrofitServiceManager()
                    .create(ApiService.class).OrderList(page,10,type,step)
                    .compose(ResponseTransformer.<Order>handleResult())
                    .compose(RxSchedulers.<Order>ObToMain())
                    .subscribe(new Consumer<Order>() {
                        @Override
                        public void accept(Order orderBaseEntity) throws Exception {
                            getMvpView().onDataSuccess(orderBaseEntity);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getMvpView().onError(throwable.getMessage());
                        }
                    }));
        }



    }

    public void cancleOrder(long id){

            addSubscribe(App.getInstance().getRetrofitServiceManager()
                    .create(ApiService.class).CancleOrder(id)
                    .compose(ResponseTransformer.<String>handleResult())
                    .compose(RxSchedulers.<String>ObToMain())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            getMvpView().onCancelSuccess();
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            getMvpView().onError(throwable.getMessage());
                        }
                    }));
        }





//    class myConsumer implements Consumer<ApiException> {
//
//
//    }



}
