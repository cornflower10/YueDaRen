package com.qingmang.serviceIntroduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
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
        implements AddressListView<List<Adress>>, OnRefreshListener {

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.ll_list)
    LinearLayout llList;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private AdressListAdapter adressListAdapter;
    private List<Adress> adresses = new ArrayList<>();
    private static final int REQ = 123;
    public static final String FROM = "AddressListActivity";

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
        srl.finishRefresh();
        stopProgressDialog();
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
        adressListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_edit:
                   Intent intent =new Intent(mContext,AddAddressActivity.class);
                   intent.putExtra("address",adresses.get(position));
                   intent.putExtra(FROM,true);
                          startActivityForResult(intent,REQ);
                        break;
                    case R.id.tv_delete:
                        startProgressDialog();
                        presenter.deleteAddress(adresses.get(position).getId());
                        break;
                    case R.id.cb_defult:
                        startProgressDialog();
                        presenter.setDefultAddress(adresses.get(position).getId());

                        break;
                }

            }
        });
        adressListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = getIntent();
                intent.putExtra("address",adresses.get(position));
                setResult(RESULT_OK,intent);
                finish();
            }
        });
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
                loadViewHelper.restore();
                loadViewHelper.showLoading("");
                presenter.addressList();
            }

        }
    }


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        presenter.addressList();
    }

    @Override
    public void onError(String msg) {
        super.onError(msg);
        srl.finishRefresh();
        stopProgressDialog();
        loadViewHelper.restore();
    }


}
