package com.qingmang.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.qingmang.baselibrary.utils.LogManager;


/**
 * Created by caomingyu on 2016/5/28.
 */
public class BaseActivity extends AppCompatActivity {
    private Toast toast = null;
    public Context mContext;
    private int count = 0;
    private ProgressDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LogManager.i("新建"+this.getClass().getName());
        super.onCreate(savedInstanceState);

        mContext=this;

//        MyApplication.getInstance().addActivity(this);
//        PushAgent.getInstance(this).onAppStart();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        BaseActivity.getInstance().finishActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogManager.i("保存onSaveInstanceState");
        outState.putBoolean("recyle",true);
    }

    public void showToast(String msg){
        if(null!=toast){
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
        }else
        {
            toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(mContext, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


        /**
     * 开启加载进度条
     */
    public void startProgressDialog() {
        count++;
        if (count == 1) {
            loadingDialog = ProgressDialog.show(mContext,"","请等待...",true,false);
        }
    }

//    /**
//     * 开启加载进度条
//     *
//     * @param msg
//     */
//    public void startProgressDialog(String msg) {
//        LoadingDialog.showDialogForLoading(getActivity(), msg, true);
//
//    }

    /**
     * 停止加载进度条
     */
    public void stopProgressDialog() {
        count--;
        if (count == 0) {
            loadingDialog.cancel();
        }

    }
    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(mContext, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

}
