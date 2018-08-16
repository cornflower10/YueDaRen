package com.qingmang.serviceIntroduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qingmang.R;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.CommonPresenter;
import com.qingmang.base.CommonView;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.moudle.entity.Invoice;

import butterknife.BindView;
import butterknife.OnClick;

public class InvoiceChooseActivity extends BaseMvpActivity<CommonPresenter, CommonView> implements CommonView {

    @BindView(R.id.rg_invoice)
    RadioGroup rgInvoice;
    @BindView(R.id.rb_un_invoice)
    RadioButton rbUnInvoice;
    @BindView(R.id.rb_invoice)
    RadioButton rbInvoice;
    private boolean un_invoice;
    private Invoice invoice;

    @Override
    public String setTitleName() {
        return "设置发票信息";
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return R.layout.activity_invoice_setting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rgInvoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rb_un_invoice:
                        un_invoice = true;
                        break;
                    case R.id.rb_invoice:
                        un_invoice = false;
                        break;
                }
            }
        });
        invoice = getIntent().getParcelableExtra("invoice");
        if (invoice.isInvoice()) {
            rbInvoice.setChecked(true);

        }else {
            rbUnInvoice.setChecked(true);
        }
    }

    @Override
    public void onDataSuccess(Object o) {

    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresenterLoder(mContext, new PresenterFactory() {
            @Override
            public Presenter crate() {
                return new CommonPresenter();
            }
        });
    }

    @OnClick(R.id.bt_sure)
    public void onViewClicked() {
        if (un_invoice) {
            invoice.setInvoice(false);
            Intent intent = getIntent();
            intent.putExtra("invoice", invoice);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            invoice.setInvoice(true);
            Intent in = new Intent(mContext, InvoiceSettingActivity.class);
            in.putExtra("invoice", invoice);
            startActivityForResult(in,888);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Intent intent = getIntent();
            intent.putExtra("invoice", data.getParcelableExtra("invoice"));
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
