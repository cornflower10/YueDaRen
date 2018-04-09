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

public class OrderSurePresenter extends BaseMvpPresenter<OrderSureView> {

    public void loadData(long id, int num, String choose,
                         String chooseCity,
                         String choosedis,
                         long addressId,
                         int ticket,
                         int invoice,
                         int invoiceDetail,
                         String company,
                         String taxpayer ){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class)
                .Order(id,num,choose,chooseCity,choosedis,addressId,
                        ticket,invoice,invoiceDetail,company,taxpayer)
                .compose(ResponseTransformer.<String>handleResult())
                .compose(RxSchedulers.<String>ObToMain())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                            getMvpView().onDataSuccess(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }


    public void addressDefult(){
        addSubscribe(App.getInstance()
                .getRetrofitServiceManager()
                .create(ApiService.class)
                .AddressList()
                .compose(ResponseTransformer.<List<Adress>>handleResult())
                .compose(RxSchedulers.<List<Adress>>ObToMain())
                .subscribe(new Consumer<List<Adress>>() {
                    @Override
                    public void accept(List<Adress> adressList) throws Exception {
                        if(null==adressList ||adressList.size()==0){
                            getMvpView().onEmptyDedult();
                        }else {
                            for (Adress a : adressList) {
                                if(a.getTop()==1){
                                    getMvpView().onAddressDefult(a);
                                    break;
                                }
                            }

                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

}
