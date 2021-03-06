package com.qingmang.home;

/**
 * Created by xiejingbao on 2018/3/16.
 */

import com.qingmang.base.BaseView;
import com.qingmang.moudle.entity.Banner;
import com.qingmang.moudle.entity.HotMessage;
import com.qingmang.moudle.entity.HotService;

import java.util.List;

public interface HomeView<D> extends BaseView{
    void onDataSuccess(D d);
    void onBannerSuccess(Banner banner);
    void onMindBannerSuccess(Banner banner);
    void onHotServieSuccess(List<HotService> services);
    void onHotMessageSuccess(HotMessage hotMessage);
}
