package com.qingmang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewLoadHtmlActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;
    String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_load_html);
        ButterKnife.bind(this);

        mUrl = getIntent().getStringExtra("url");
        if (mUrl != null) {

            init();

        }
    }


    private void init() {

        StringBuilder data = new StringBuilder("<html><body >");
        data.append(mUrl) ;
        data.append("</body></html>");

        webView.loadDataWithBaseURL("", data.toString(), "text/html", "UTF-8","");
    }

    public static void startWebViewActivity(Context context, String title, String url){
        Intent intent =new Intent(context,WebActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("url",url);
        context.startActivity(intent);

    }
}
