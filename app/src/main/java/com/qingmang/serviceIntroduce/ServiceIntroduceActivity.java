package com.qingmang.serviceIntroduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.moudle.entity.ServiceInfo;
import com.qingmang.utils.imageload.ImageLoaderUtil;

import butterknife.BindView;
import butterknife.OnClick;


public class ServiceIntroduceActivity extends BaseMvpActivity<ServiceIntroducePresenter, ServiceIntroduceView>
        implements ServiceIntroduceView<ServiceInfo> {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_context)
    TextView tvContext;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
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
    //    @BindView(R.id.cb_agreement)
//    AppCompatCheckBox cbAgreement;
    @BindView(R.id.nsv)
    NestedScrollView nsv;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.tv_per_service)
    TextView tvPerService;
    @BindView(R.id.tv_one_one)
    TextView tvOneOne;
    @BindView(R.id.rl_light)
    RelativeLayout rlLight;
    private ServiceInfo serviceInfo;
    private int id;

    @Override
    public String setTitleName() {
        return "服务介绍";
    }

    @Override
    public View getRootView() {
        return llRoot;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_service_introduce;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getIntent().getIntExtra("id", 0);
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
                Intent intent = new Intent(mContext, OrderSureActivity.class);
                intent.putExtra("serviceInfo",serviceInfo);
                startActivity(OrderSureActivity.class);
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
        loadViewHelper.showLoading("");
        presenter.loadData(id);
    }

    @Override
    public void onDataSuccess(ServiceInfo serviceIntroduce) {
        loadViewHelper.restore();
        serviceInfo = serviceIntroduce;
        tvTitle.setText(serviceIntroduce.getName());
        tvContext.setText(serviceIntroduce.getPoster());
        tvAmount.setText(String.valueOf(serviceIntroduce.getPrice()));
        ImageLoaderUtil.getInstance().loadLocalImage(serviceIntroduce.getLogo(), iv, 0);
        if (!TextUtils.isEmpty(serviceIntroduce.getLights())) {
            String[] strings = serviceIntroduce.getLights().split("，");
            if (strings.length == 2) {
                tvPerService.setText(strings[0]);
                tvOneOne.setText(strings[1]);
            }else {
                rlLight.setVisibility(View.GONE);
            }

        } else {
            rlLight.setVisibility(View.GONE);
        }

//        serviceIntroduce.getSpecial()

    }
}
