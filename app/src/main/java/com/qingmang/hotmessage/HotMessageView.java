package com.qingmang.hotmessage;

/**
 * Created by xiejingbao on 2018/3/16.
 */

import com.qingmang.base.BaseView;
import com.qingmang.moudle.entity.HotMessage;

public interface HotMessageView extends BaseView{

    void onHotMessageSuccess(HotMessage hotMessage);
}
