package com.qingmang.serviceIntroduce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lljjcoder.Interface.OnCityItemClickListener;
import com.lljjcoder.bean.CityBean;
import com.lljjcoder.bean.DistrictBean;
import com.lljjcoder.bean.ProvinceBean;
import com.lljjcoder.citywheel.CityConfig;
import com.lljjcoder.style.citypickerview.CityPickerView;
import com.qingmang.App;
import com.qingmang.R;
import com.qingmang.adapter.ServiceObjectAdapter;
import com.qingmang.adapter.ServicePagerAdapter;
import com.qingmang.base.BaseMvpActivity;
import com.qingmang.base.Presenter;
import com.qingmang.base.PresenterFactory;
import com.qingmang.base.PresenterLoder;
import com.qingmang.baselibrary.utils.AmountUtils;
import com.qingmang.custom.Banner;
import com.qingmang.moudle.entity.Item;
import com.qingmang.moudle.entity.ServiceInfo;
import com.qingmang.moudle.entity.ServiceObject;
import com.qingmang.utils.imageload.ImageLoaderUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class ServiceIntroduceActivity extends BaseMvpActivity<ServiceIntroducePresenter, ServiceIntroduceView>
        implements ServiceIntroduceView<ServiceInfo> {

    @BindView(R.id.iv)
    Banner iv;
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
//    @BindView(R.id.nsv)
//    NestedScrollView nsv;
    @BindView(R.id.ll_root)
    LinearLayout llRoot;
    @BindView(R.id.tv_per_service)
    TextView tvPerService;
    @BindView(R.id.tv_one_one)
    TextView tvOneOne;
    @BindView(R.id.rl_light)
    RelativeLayout rlLight;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tb)
    TabLayout tb;
    @BindView(R.id.rv_object)
    RecyclerView rvObject;
    @BindView(R.id.rv_project)
    RecyclerView rvProject;
    @BindView(R.id.ll_scroll)
    LinearLayout llScroll;
    @BindView(R.id.rl_ob)
    RelativeLayout rlOb;
    @BindView(R.id.rl_pro)
    RelativeLayout rlPro;
    private ServiceInfo serviceInfo;
    private int id;
    CityPickerView mCityPickerView = new CityPickerView();
    private int count = 1;
    private List<String> list = new ArrayList<>();
    private String[] titles = {"服务说明", "服务流程", "服务承诺", "常见问题"};
    private String chooseObject;
    private String chooseProject;
    private String chooseObjectKey;
    private String chooseProjectKey;


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
        return R.layout.activity_service_introduce_test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getIntent().getIntExtra("id", 0);
//        mCityPickerView.init(mContext);
        initWheel();
        tvCount.setText(String.valueOf(count));
//        EventBus.getDefault().register(this);


    }


    public static void startActivity(Context context, int id) {
        Intent intent = new Intent(context, ServiceIntroduceActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    private void initTb(List<String> list) {
        vp.setAdapter(new ServicePagerAdapter(getSupportFragmentManager(), list, titles));
        tb.addTab(tb.newTab());
        tb.addTab(tb.newTab());
        tb.addTab(tb.newTab());
        tb.addTab(tb.newTab());
        tb.setupWithViewPager(vp);
    }

    @OnClick({R.id.tv_per_service,
            R.id.tv_service_ob, R.id.iv_minus,
            R.id.iv_add, R.id.bt_buy, R.id.tv_palce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_per_service:
                break;
            case R.id.tv_service_ob:
                break;

            case R.id.iv_minus:
                count--;
                if (count < 0)
                    count = 0;
                tvCount.setText(String.valueOf(count));
                break;
            case R.id.iv_add:
                count++;
                tvCount.setText(String.valueOf(count));
                break;
            case R.id.bt_yy:
                buy();
                break;
            case R.id.tv_palce:
                mCityPickerView.showCityPicker();
                break;
            case R.id.bt_buy:
                buy();
                break;
        }
    }

    private void buy() {

        if (!App.getInstance().isLogin()) {
            startLoginActivity();
            return;
        }

        if (count == 0) {
            showToast(" 请选择服务数量！");
            return;
        }

        Intent intent = new Intent(mContext, OrderSureActivity.class);
        List<ServiceInfo.Choose> chooseList =new ArrayList<>();

        if(!TextUtils.isEmpty(chooseObjectKey)){
            ServiceInfo.Choose choose = new ServiceInfo.Choose();
            choose.setKey(chooseObjectKey);
            choose.setValue(chooseObject);
            chooseList.add(choose);
        }

        if(!TextUtils.isEmpty(chooseProjectKey)){
            ServiceInfo.Choose choose = new ServiceInfo.Choose();
            choose.setKey(chooseProjectKey);
            choose.setValue(chooseProject);
            chooseList.add(choose);
        }
     serviceInfo.setChooses(chooseList);

        if (TextUtils.isEmpty(tvPalce.getText().toString())) {
            serviceInfo.setPlace("");
            showToast("请选择服务区域！");
            return;

        } else {
            serviceInfo.setPlace(tvPalce.getText().toString());
        }
        serviceInfo.setNum(count);
        intent.putExtra("serviceInfo", serviceInfo);
        startActivity(intent);
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
        tvAmount.setText(AmountUtils.amountFormat(serviceIntroduce.getPrice())+"元");

       String logos = serviceIntroduce.getLogos();
       if(!TextUtils.isEmpty(logos)){
           String [] los = logos.split(",");
           iv.setImageLoader(new Banner.ImageLoader() {
               @Override
               public void displayImage(Context context, String path, ImageView imageView) {
                   ImageLoaderUtil.getInstance().showImage(path,imageView,0);
               }
           });
           iv.setViewUrls(Arrays.asList(los));
           if(los.length>1){
               iv.setAutoPlay(true);
           }else {
               iv.setAutoPlay(false);
           }

       }

//        if (!TextUtils.isEmpty(serviceIntroduce.getLights())) {
//            String[] strings = serviceIntroduce.getLights().split("，");
//            if (strings.length == 2) {
//                tvPerService.setText(strings[0]);
//                tvOneOne.setText(strings[1]);
//            } else {
//                rlLight.setVisibility(View.GONE);
//            }
//
//        } else {
//            rlLight.setVisibility(View.GONE);
//        }

        Gson gson = new Gson();
        List<Item> items = gson.fromJson(serviceInfo.getSpecial(), new TypeToken<List<Item>>() {
        }.getType());
        if (null != items && items.size() > 0) {
            String[] s = items.get(0).getItems().split(",");
            chooseObjectKey = items.get(0).getKey();
            tvServiceOb.setText(chooseObjectKey);
            final List<ServiceObject> serviceProjects = new ArrayList<>();
            if (items.size() == 2) {
                String[] spe = items.get(1).getItems().split(",");
                for (int i = 0; i < spe.length; i++) {
                    ServiceObject so = new ServiceObject();
                    so.setName(spe[i]);
                    serviceProjects.add(so);
                }
                chooseProjectKey = items.get(1).getKey();
                tvPro.setText(chooseProjectKey);

            } else {
                rlPro.setVisibility(View.GONE);
            }

            final List<ServiceObject> serviceObjects = new ArrayList<>();

            for (int i = 0; i < s.length; i++) {
                ServiceObject serviceObject = new ServiceObject();
                serviceObject.setName(s[i]);
                serviceObjects.add(serviceObject);
            }
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 2);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            if (null != serviceObjects && serviceObjects.size() > 0) {
                chooseObject = serviceObjects.get(0).getName();
                serviceObjects.get(0).setChoose(true);
            }
            final ServiceObjectAdapter serviceObjectAdapter = new ServiceObjectAdapter(serviceObjects);
            serviceObjectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (!serviceObjects.get(position).isChoose()) {
                        serviceObjects.get(position).setChoose(true);
                        chooseObject = serviceObjects.get(position).getName();
                        for (ServiceObject s : serviceObjects) {
                            if (serviceObjects.get(position).getName().equals(s.getName()))
                                continue;
                            s.setChoose(false);
                        }
                        serviceObjectAdapter.notifyDataSetChanged();
                    }

                }
            });
            rvObject.setAdapter(serviceObjectAdapter);
            rvObject.setLayoutManager(layoutManager);

            if (null != serviceProjects && serviceProjects.size() > 0) {
                chooseProject = serviceProjects.get(0).getName();
                serviceProjects.get(0).setChoose(true);
            }

            final ServiceObjectAdapter serviceProjectAdapter = new ServiceObjectAdapter(serviceProjects);
            serviceProjectAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    if (!serviceProjects.get(position).isChoose()) {
                        serviceProjects.get(position).setChoose(true);
                        chooseProject = serviceProjects.get(position).getName();
                        for (ServiceObject s : serviceProjects) {
                            if (serviceProjects.get(position).getName().equals(s.getName()))
                                continue;
                            s.setChoose(false);
                        }
                        serviceProjectAdapter.notifyDataSetChanged();
                    }
                }
            });

//            LinearLayoutManager linearLayout = new LinearLayoutManager(this);
//            linearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
            rvProject.setAdapter(serviceProjectAdapter);
            rvProject.setLayoutManager(gridLayoutManager);
        } else {
            rlOb.setVisibility(View.GONE);
            rlPro.setVisibility(View.GONE);
        }

//        serviceIntroduce.getSpecial()
        list.add(serviceIntroduce.getIntroduce());
        list.add(serviceIntroduce.getFlow());
        list.add(serviceIntroduce.getGuarantee());
        list.add(serviceIntroduce.getProblem());

        initTb(list);

        initProvinceData();

    }

    private void initProvinceData() {

        if (serviceInfo.getRegions().size() > 1) {
            ArrayList<ProvinceBean> arrayList = new ArrayList<>();
            ProvinceBean provinceBean = new ProvinceBean();
            provinceBean.setId("10000");
            provinceBean.setName("广东省");
            ArrayList<CityBean> cityBeans = new ArrayList<>();
            for (int i = 0; i < serviceInfo.getRegions().size(); i++) {
                CityBean cityBean = new CityBean();
                cityBean.setId("10000" + i);
                ServiceInfo.RegionsBean regionsBean = serviceInfo.getRegions().get(i);
                cityBean.setName(regionsBean.getP());
                ArrayList<DistrictBean> districtBeans = new ArrayList<>();
                String[] p = regionsBean.getC().split(",");
                for (int j = 0; j < p.length; j++) {
                    DistrictBean districtBean = new DistrictBean();
                    districtBean.setId(cityBean.getId() + j);
                    districtBean.setName(p[j]);
                    districtBeans.add(districtBean);
                }
                cityBean.setCityList(districtBeans);
                cityBeans.add(cityBean);
            }
            provinceBean.setCityList(cityBeans);
            arrayList.add(provinceBean);
            Gson gsons = new Gson();
            String data = gsons.toJson(arrayList);
            mCityPickerView.init(mContext, data);

        } else if (serviceInfo.getRegions().size() == 1) {
            mCityPickerView.init(mContext);
        }
    }

    /**
     * 弹出选择器
     */
    private void initWheel() {

//        defaultProvinceName   = mProEt.getText().toString();
//        defaultCityName = mCityEt.getText().toString();
//        defaultDistrict = mAreaEt.getText().toString();
//
//        visibleItems = (Integer.parseInt(mProVisibleCountEt.getText().toString()));

        CityConfig cityConfig = new CityConfig.Builder().title("选择城市")//标题
                .build();

        mCityPickerView.setConfig(cityConfig);
        mCityPickerView.setOnCityItemClickListener(new OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                StringBuilder sb = new StringBuilder();
                if (province != null) {
                    sb.append(province.getName() + ",");
                }

                if (city != null) {
                    sb.append(city.getName() + ",");
                }

                if (district != null) {
                    sb.append(district.getName());
                }

                tvPalce.setText("" + sb.toString());

            }

            @Override
            public void onCancel() {
//                ToastUtils.showLongToast(CitypickerWheelActivity.this, "已取消");
            }
        });

    }


    //    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(MessageEvent event) {
//        /* Do something */
//      llScroll.requestDisallowInterceptTouchEvent(true);
//
//    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
