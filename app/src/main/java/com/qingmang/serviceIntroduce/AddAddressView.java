package com.qingmang.serviceIntroduce;

/**
 * Created by xiejingbao on 2018/3/16.
 */

import com.qingmang.base.BaseView;

public interface AddAddressView<D> extends BaseView{
    void onDataSuccess(D d);
    void onDataUpdateSuccess();
}
