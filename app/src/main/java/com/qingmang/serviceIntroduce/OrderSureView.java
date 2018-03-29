package com.qingmang.serviceIntroduce;

/**
 * Created by xiejingbao on 2018/3/16.
 */

import com.qingmang.base.BaseView;

public interface OrderSureView<D> extends BaseView{
    void onDataSuccess(D d);
}
