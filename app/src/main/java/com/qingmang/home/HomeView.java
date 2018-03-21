package com.qingmang.home;

/**
 * Created by xiejingbao on 2018/3/16.
 */

import com.qingmang.base.BaseView;
import com.qingmang.moudle.entity.Banner;

public interface HomeView<D> extends BaseView{
    void onDataSuccess(D d);
    void onBannerSuccess(Banner banner);
}
