package com.qingmang.serviceIntroduce;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.moudle.entity.ServiceIntroduce;

import butterknife.BindView;
import butterknife.OnClick;


public class ServiceIntroduceActivity extends BaseMvpActivity<ServiceIntroducePresenter, ServiceIntroduceView>
        implements ServiceIntroduceView<ServiceIntroduce> {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_context)
    TextView tvContext;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.tv_per_service)
    TextView tvPerService;
    @BindView(R.id.tv_service_ob)
    TextView tvServiceOb;
    @BindView(R.id.tv_pro)
    TextView tvPro;
    @BindView(R.id.tv_yj)
    TextView tvYj;
    @BindView(R.id.tv_jf)
    TextView tvJf;
    @BindView(R.id.tv_palce)
    TextView tvPalce;
    @BindView(R.id.iv_minus)
    ImageView ivMinus;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.cb_agreement)
    AppCompatCheckBox cbAgreement;
    @BindView(R.id.nsv)
    NestedScrollView nsv;

    @Override
    public String setTitleName() {
        return "服务介绍";
    }

    @Override
    public View getRootView() {
        return nsv;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_service_introduce;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.tv_per_service, R.id.tv_service_ob, R.id.tv_yj, R.id.tv_jf, R.id.iv_minus, R.id.iv_add, R.id.bt_yy, R.id.bt_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_per_service:
                break;
            case R.id.tv_service_ob:
                break;
            case R.id.tv_yj:
                break;
            case R.id.tv_jf:
                break;
            case R.id.iv_minus:
                break;
            case R.id.iv_add:
                break;
            case R.id.bt_yy:
                break;
            case R.id.bt_buy:
                break;
        }
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public Presenter crate() {
                return new ServiceIntroducePresenter();
            }
        });
    }

    @Override
    public void onLoadFinished(Loader<ServiceIntroducePresenter> loader, ServiceIntroducePresenter data) {
        super.onLoadFinished(loader, data);
//        loadViewHelper.showLoading("");
//        presenter.loadData();
    }

    @Override
    public void onDataSuccess(ServiceIntroduce serviceIntroduce) {

    }
}
