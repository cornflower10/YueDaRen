package com.qingmang.hotmessage;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.moudle.entity.HotMessage;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class HotMessagePresenter extends BaseMvpPresenter<HotMessageView> {


    /**
     * 热点资讯
     */
    public void loadHotMessage(int page,final boolean isLoadMore){
        addSubscribe(App.getInstance().getRetrofitServiceManager().create(ApiService.class).HotMessages(page,10)
                .compose(ResponseTransformer.<HotMessage>handleResult())
                .compose(RxSchedulers.<HotMessage>ObToMain())
                .subscribe(new Consumer<HotMessage>() {
                    @Override
                    public void accept(HotMessage hotMessage) throws Exception {
                        if(isLoadMore){
                            getMvpView().onLoadMoreSuccess(hotMessage);
                        }else {
                            getMvpView().onHotMessageSuccess(hotMessage);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(isLoadMore){
                            getMvpView().onLoadMoreFail(throwable.getMessage());
                        }else {
                            getMvpView().onError(throwable.getMessage());
                        }

                    }
                }));

    }
}
