package com.qingmang.home;

import com.qingmang.App;
import com.qingmang.api.ApiService;
import com.qingmang.base.BaseMvpPresenter;
import com.qingmang.moudle.entity.Banner;
import com.qingmang.moudle.entity.HotMessage;
import com.qingmang.moudle.entity.HotService;
import com.qingmang.moudle.entity.Service;
import com.qingmang.utils.RxSchedulers;
import com.qingmang.utils.rx.ResponseTransformer;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by xiejingbao on 2018/3/16.
 */

public class HomePresenter extends BaseMvpPresenter<HomeView> {

    public void loadTopBanner(){
        addSubscribe(App.getInstance().getRetrofitServiceManager().create(ApiService.class).topBanner()
                .compose(ResponseTransformer.<Banner>handleResult())
                .compose(RxSchedulers.<Banner>ObToMain())
                .subscribe(new Consumer<Banner>() {
                    @Override
                    public void accept(Banner banner) throws Exception {
                            getMvpView().onBannerSuccess(banner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }



    /**
     *
     */
    public void loadMindBanner(){
        addSubscribe(App.getInstance().getRetrofitServiceManager().create(ApiService.class).MindBanner()
                .compose(ResponseTransformer.<Banner>handleResult())
                .compose(RxSchedulers.<Banner>ObToMain())
                .subscribe(new Consumer<Banner>() {
                    @Override
                    public void accept(Banner banner) throws Exception {
                        getMvpView().onMindBannerSuccess(banner);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }


    /**
     *
     */
    public void loadHotService(){
        addSubscribe(App.getInstance().getRetrofitServiceManager().create(ApiService.class).HotService()
                .compose(ResponseTransformer.<List<HotService>>handleResult())
                .compose(RxSchedulers.<List<HotService>>ObToMain())
                .subscribe(new Consumer<List<HotService>>() {
                    @Override
                    public void accept(List<HotService> services) throws Exception {
                        getMvpView().onHotServieSuccess(services);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }

    /**
     * 热点资讯
     */
    public void loadHotMessage(){
        addSubscribe(App.getInstance().getRetrofitServiceManager().create(ApiService.class).HotMessages()
                .compose(ResponseTransformer.<HotMessage>handleResult())
                .compose(RxSchedulers.<HotMessage>ObToMain())
                .subscribe(new Consumer<HotMessage>() {
                    @Override
                    public void accept(HotMessage hotMessage) throws Exception {
                        getMvpView().onHotMessageSuccess(hotMessage);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onError(throwable.getMessage());
                    }
                }));

    }
}
