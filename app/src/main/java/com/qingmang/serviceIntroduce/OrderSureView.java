package com.qingmang.serviceIntroduce;

/**
 * Created by xiejingbao on 2018/3/16.
 */

import com.qingmang.base.BaseView;
import com.qingmang.moudle.entity.Adress;

public interface OrderSureView<D> extends BaseView{
    void onDataSuccess(D d);
    void onAddressDefult(Adress adress);
    void onEmptyDedult();
}
