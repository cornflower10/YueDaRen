package com.qingmang.serviceIntroduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.qingmang.R;
import com.qingmang.adapter.AdressListAdapter;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.moudle.entity.Adress;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AddressListActivity extends BaseMvpActivity<AddressListPresenter, AddressListView>
        implements AddressListView<List<Adress>>,OnRefreshListener {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.ll_list)
    LinearLayout llList;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private AdressListAdapter adressListAdapter;
    private List<Adress> adresses = new ArrayList<>();
    private static final int REQ = 123;

    @Override
    public String setTitleName() {
        return "管理联系地址";
    }

    @Override
    public View getRootView() {
        return llList;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_address_list;
    }


    @OnClick(R.id.bt_add_address)
    public void onViewClicked() {
        startActivityForResult(AddAddressActivity.class, REQ);
    }

    @Override
    public void onDataSuccess(List<Adress> adressList) {
        loadViewHelper.restore();
        adressListAdapter.replaceData(adressList);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public Presenter crate() {
                return new AddressListPresenter();
            }
        });
    }

    @Override
    public void onLoadFinished(Loader<AddressListPresenter> loader, AddressListPresenter data) {
        super.onLoadFinished(loader, data);
        srl.setOnRefreshListener(this);
        srl.setEnableLoadmore(false);
        adressListAdapter = new AdressListAdapter(adresses);
        rvList.setAdapter(adressListAdapter);
        rvList.setLayoutManager(new LinearLayoutManager(mContext));
        loadViewHelper.showLoading("");
        presenter.addressList();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ) {
            if (resultCode == RESULT_OK) {
                loadViewHelper.showLoading("");
                presenter.addressList();
            }

        }
    }


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        presenter.addressList();
    }
}
