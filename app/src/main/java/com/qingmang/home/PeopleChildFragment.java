package com.qingmang.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.qingmang.R;

/**
 * Created by xiejingbao on 2018/3/19.
 */

public class PeopleChildFragment extends Fragment {
    String[] array = new String[]{"Android 1", "Android 2", "Android 3",
            "Android 4", "Android 5", "Android 6", "Android 7", "Android 8",
            "Android 9", "Android 10", "Android 11", "Android 12", "Android 13",
            "Android 14", "Android 15", "Android 16"};

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

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
            case 0:
                break;

            case 1:
                rootView.setBackgroundColor(Color.BLACK);
                break;

            case 2:
                rootView.setBackgroundColor(Color.BLUE);
                break;

            case 3:
                rootView.setBackgroundColor(Color.GREEN);
                break;

            case 4:
                rootView.setBackgroundColor(Color.RED);
                break;
        }
        final ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(getActivity(),
                R.layout.list_item, R.id.text1, array));

        return rootView;
    }
}
