package com.qingmang.serviceIntroduce;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.qingmang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class ServiceIntroducePagerFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    @BindView(R.id.wv)
    WebView wv;
    Unbinder unbinder;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static ServiceIntroducePagerFragment newInstance(String content) {
        ServiceIntroducePagerFragment fragment = new ServiceIntroducePagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_NUMBER, content);
        fragment.setArguments(args);
        return fragment;
    }

    public ServiceIntroducePagerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.service_introduce_pager_view, container, false);

        Log.d("Debug", "creating fragment "
                + getArguments().getString(ARG_SECTION_NUMBER));
        unbinder = ButterKnife.bind(this, rootView);

        init(wv,getArguments().getString(ARG_SECTION_NUMBER));

        return rootView;
    }


    private void init(WebView webView,String mUrl) {

        StringBuilder data = new StringBuilder("<html><body >");
        data.append(mUrl) ;
        data.append("</body></html>");

        webView.loadDataWithBaseURL("", data.toString(), "text/html", "UTF-8","");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
