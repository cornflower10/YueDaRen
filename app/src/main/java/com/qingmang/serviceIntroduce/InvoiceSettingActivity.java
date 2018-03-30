package com.qingmang.serviceIntroduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class InvoiceSettingActivity extends BaseMvpActivity<CommonPresenter, CommonView> implements CommonView {

    @BindView(R.id.rb_paper)
    RadioButton rbPaper;
    @BindView(R.id.rb_ele)
    RadioButton rbEle;
    @BindView(R.id.rb_zengzhi)
    RadioButton rbZengzhi;
    @BindView(R.id.rg_invoice_type)
    RadioGroup rgInvoiceType;
    @BindView(R.id.rb_person)
    RadioButton rb_person;
    @BindView(R.id.rb_company)
    RadioButton rb_company;
    @BindView(R.id.rg_type)
    RadioGroup rgType;
    @BindView(R.id.et_company_name)
    EditText etCompanyName;
    @BindView(R.id.et_invoice)
    EditText etInvoice;
    @BindView(R.id.ll_detail)
    LinearLayout llDetail;

    private boolean personal = true;
    private int invoiceType;
    private Invoice invoice = new Invoice();

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
        return R.layout.activity_invoice_setting2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        invoice = getIntent().getParcelableExtra("invoice");
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rb_person:
                        personal = true;
                        break;
                    case R.id.rb_company:
                        personal = false;
                        break;
                }
                isPersonal(personal);
            }
        });

        rgInvoiceType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.rb_paper:
                        invoiceType = 0;
                        break;
                    case R.id.rb_ele:
                        invoiceType = 1;
                        break;
                    case R.id.rb_zengzhi:
                        invoiceType = 2;
                        break;
                }
            }
        });
        rb_person.setChecked(true);
        rbPaper.setChecked(true);
        isPersonal(personal);

    }

    private void isPersonal(boolean isPersonal) {
        if (isPersonal) {
            rbPaper.setChecked(true);
            llDetail.setVisibility(View.GONE);
            rbPaper.setVisibility(View.VISIBLE);
            rbEle.setVisibility(View.GONE);
            rbZengzhi.setVisibility(View.GONE);
        } else {
            rbEle.setChecked(true);
            rbPaper.setVisibility(View.GONE);
            llDetail.setVisibility(View.VISIBLE);
            rbEle.setVisibility(View.VISIBLE);
            rbZengzhi.setVisibility(View.VISIBLE);
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
        if(!personal){
            if(TextUtils.isEmpty(etCompanyName.getText().toString())){
                showToast("请填写单位名称");
                return;
            }

            if(TextUtils.isEmpty(etInvoice.getText().toString())){
                showToast("请填写纳税人识别号");
                return;
            }
            invoice.setCompanyName(etCompanyName.getText().toString());
            invoice.setInvoiceNo(etInvoice.getText().toString());
        }
        invoice.setHeader(personal?0:1);

        invoice.setInvoiceType(invoiceType);
        Intent intent = getIntent();
        intent.putExtra("invoice",invoice);
        setResult(RESULT_OK, intent);
        finish();
    }
}
