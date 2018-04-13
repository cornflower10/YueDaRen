package com.qingmang.serviceIntroduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingmang.App;
import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.moudle.entity.Adress;
import com.qingmang.moudle.entity.Invoice;
import com.qingmang.moudle.entity.MessageEvent;
import com.qingmang.moudle.entity.ServiceInfo;
import com.qingmang.utils.imageload.ImageLoaderUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class OrderSureActivity extends BaseMvpActivity<OrderSurePresenter, OrderSureView> implements OrderSureView<String> {

    @BindView(R.id.tv_fa_piao)
    TextView tvFaPiao;
    private static final int REQ = 123;
    private static final int REQ_ADDRESS = 124;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_address_top)
    TextView tvAddressTop;
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
    @BindView(R.id.tv_liuyan)
    TextView tvLiuyan;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_write)
    TextView tvWrite;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    private Invoice invoice = new Invoice();

    private ServiceInfo serviceInfo;

    @Override
    public String setTitleName() {
        return "确认订单";
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_order_sure;
    }

    private StringBuilder stringBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stringBuilder = new StringBuilder();
        serviceInfo = (ServiceInfo) getIntent().getSerializableExtra("serviceInfo");
        if (null != serviceInfo) {
            ImageLoaderUtil.getInstance().showImage(serviceInfo.getLogo(), iv, 0);
            tvTitle.setText("服务名称：" + serviceInfo.getName());
            List<ServiceInfo.Choose> choose = serviceInfo.getChooses();
            if (null!=choose&&choose.size()>0) {
                for (int i = 0; i < choose.size(); i++) {
                    if(i==0){
                        tvContext.setText(choose.get(0).getKey()+"：" + choose.get(0).getValue());
                        stringBuilder.append(choose.get(0).getValue());
                    }
                    if(i==1){
                        tvAmount.setText(choose.get(1).getKey()+"：" + choose.get(1).getValue());
                        stringBuilder.append(",");
                        stringBuilder.append(choose.get(1).getValue());
                    }

                }

            }

        }
    }

    @OnClick({R.id.ll_location, R.id.tv_fa_piao, R.id.bt_add_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_location:
                Intent intent = new Intent(this, AddressListActivity.class);
                startActivityForResult(intent, REQ_ADDRESS);
                break;
            case R.id.tv_fa_piao:
                Intent intentFP = new Intent(this, InvoiceChooseActivity.class);
                if (tvFaPiao.getText().equals("不开发票")) {
                    invoice.setInvoice(false);

                } else {
                    invoice.setInvoice(true);

                }
                intentFP.putExtra("invoice", invoice);
                startActivityForResult(intentFP, REQ);

                break;
            case R.id.bt_add_address:
                if (null == adress) {
                    showToast("请选择收货地址！");
                    return;
                }
                startProgressDialog();
                presenter.loadData(serviceInfo.getId(), serviceInfo.getNum(),
                        stringBuilder.toString(),
                        cityAndDis(serviceInfo.getPlace())[0],
                        cityAndDis(serviceInfo.getPlace())[1], adress.getId(),
                        invoice.isInvoice() ? 1 : 0, invoice.getInvoiceType(), invoice.getHeader(),
                        invoice.getCompanyName(), invoice.getInvoiceNo()
                );
                break;
        }
    }

    private String[] cityAndDis(String s) {
        String[] strings = new String[2];
        if (!TextUtils.isEmpty(s)) {
            String[] strings1 = s.split(",");
            strings[0] = strings1[1];
            strings[1] = strings1[2];
        }
        return strings;

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public Presenter crate() {
                return new OrderSurePresenter();
            }
        });
    }

    @Override
    public void onLoadFinished(Loader<OrderSurePresenter> loader, OrderSurePresenter data) {
        super.onLoadFinished(loader, data);
        startProgressDialog();
        presenter.addressDefult();
    }

    @Override
    public void onDataSuccess(String s) {
        EventBus.getDefault().post(new MessageEvent(1));
        stopProgressDialog();
        showToast("购买成功");
        App.getInstance().getForegroundCallbacks().finishActivity(ServiceIntroduceActivity.class);
        finish();
    }

    @Override
    public void onAddressDefult(Adress adress) {
        stopProgressDialog();
        tvWrite.setVisibility(View.GONE);
        llAddress.setVisibility(View.VISIBLE);
        this.adress = adress;
        tvUser.setText("联系人：" + adress.getCollector());
        tvPhone.setText(adress.getMobile());
        String str = adress.getProvince() + "," + adress.getCity() + ","
                + adress.getAreas() + "," + adress.getAddress();
        tvAddressTop.setText("联系地址：" + str);
        tvAddress.setText("送至：" + str);
    }

    @Override
    public void onEmptyDedult() {
        stopProgressDialog();
        tvWrite.setVisibility(View.VISIBLE);
        llAddress.setVisibility(View.GONE);
    }

    private Adress adress;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (REQ == requestCode) {
                invoice = data.getParcelableExtra("invoice");
                tvFaPiao.setText(invoice.isInvoice() ? "开发票" : "不开发票");
            } else if (requestCode == REQ_ADDRESS) {
                tvWrite.setVisibility(View.GONE);
                llAddress.setVisibility(View.VISIBLE);
                adress = data.getParcelableExtra("address");
                tvUser.setText("联系人：" + adress.getCollector());
                tvPhone.setText(adress.getMobile());
                String str = adress.getProvince() + "," + adress.getCity() + ","
                        + adress.getAreas() + "," + adress.getAddress();
                tvAddressTop.setText("联系地址：" + str);
                tvAddress.setText("送至：" + str);

            }
        }
    }
}
