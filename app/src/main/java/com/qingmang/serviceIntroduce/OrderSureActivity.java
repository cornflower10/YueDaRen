package com.qingmang.serviceIntroduce;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.qingmang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderSureActivity extends AppCompatActivity {

    @BindView(R.id.tv_fa_piao)
    TextView tvFaPiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sure);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ll_location, R.id.tv_fa_piao, R.id.bt_add_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_location:
                Intent intent = new Intent(this,AddressListActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_fa_piao:
                break;
            case R.id.bt_add_address:
                break;
        }
    }
}
