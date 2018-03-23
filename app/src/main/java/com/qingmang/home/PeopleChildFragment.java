package com.qingmang.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qingmang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class PeopleChildFragment extends Fragment {

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PeopleChildFragment newInstance(int sectionNumber) {
        PeopleChildFragment fragment = new PeopleChildFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public PeopleChildFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.people_child_fragment, container, false);

        Log.d("Debug", "creating fragment "
                + getArguments().getInt(ARG_SECTION_NUMBER));

        switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
//            case 0:
//                break;
//
//            case 1:
//                rootView.setBackgroundColor(Color.BLACK);
//                break;
//
//            case 2:
//                rootView.setBackgroundColor(Color.BLUE);
//                break;
//
//            case 3:
//                rootView.setBackgroundColor(Color.GREEN);
//                break;
//
//            case 4:
//                rootView.setBackgroundColor(Color.RED);
//                break;
        }


        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
