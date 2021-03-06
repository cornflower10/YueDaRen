package com.qingmang.home;

/**
 * Created by xiejingbao on 2018/3/16.
 */

import com.qingmang.base.BaseView;

public interface OrderView<D> extends BaseView{
    void onDataSuccess(D d);
    void onCancelSuccess();
    void onDeleteSuccess();
    void onLoadMoreSuccess(D d);
    void onLoadMoreFail(String error);

}
