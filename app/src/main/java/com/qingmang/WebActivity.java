package com.qingmang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.CommonPresenter;
import com.qingmang.base.CommonView;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.baselibrary.utils.LogManager;

import butterknife.BindView;


/**
 * Created by caomingyu on 2016/10/28.
 */
public class WebActivity extends BaseMvpActivity<CommonPresenter,CommonView> implements CommonView {
    public static final String URL = "article/views?id=";

    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.ll_error)
    LinearLayout llError;
    private String mUrl;
    private String title;
//    private String type;

    @Override
    public String setTitleName() {
        return title;
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public int setContentView() {
        return R.layout.web;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        title = getIntent().getStringExtra("title");
        super.onCreate(savedInstanceState);
        mUrl = getIntent().getStringExtra("url");
        if (mUrl != null) {
            init();
        }else {
            showError();
        }

    }


    public static void startWebViewActivity(Context context,String title,String url){
        Intent intent =new Intent(context,WebActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("url",url);
        context.startActivity(intent);

    }

    private void showError(){
        webView.setVisibility(View.GONE);
        llError.setVisibility(View.VISIBLE);
    }



    private void init() {

        webView.loadUrl(com.qingmang.BuildConfig.URL+URL+mUrl);
        //支持javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        //不显示webview缩放按钮
        webView.getSettings().setDisplayZoomControls(false);
        //
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null) {
                    webView.loadUrl(url);
                }
                return true;
            }

            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                showError();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                showError();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                LogManager.i("onPageFinished");
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != webView) {
            webView.removeAllViews();
            try {
                webView.destroy();
            } catch (Exception e) {
               LogManager.e("webView",e);
            }
            webView = null;
        }
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

    @Override
    public void onDataSuccess(Object o) {

    }
}
