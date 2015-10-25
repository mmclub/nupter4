package com.mmclub.nupternew.fragment.timetable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mmclub.nupternew.fragment.BaseFragment;

/**
 * Created by J on 15/10/25.
 */
public class TimeTableFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }
    @Override
    public String initContent() {
        return "timetable";
    }
}
