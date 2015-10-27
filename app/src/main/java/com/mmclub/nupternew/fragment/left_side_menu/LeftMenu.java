package com.mmclub.nupternew.fragment.left_side_menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import com.mmclub.nupternew.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhao on 2015/10/27.
 */
public class LeftMenu extends Fragment{
    public View mView;
    public ListView mCategories;
    public List<String> mDatas = Arrays
            .asList("聊天", "跑操", "课程表", "二手市场", "失物招领");
    public ListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null)
        {
            initView(inflater, container);
        }
        return mView;
    }
    public void initView(LayoutInflater inflater, ViewGroup container){
        mView = inflater.inflate(R.layout.left_menu_back, container, false);
        mCategories = (ListView) mView
                .findViewById(R.id.left_menu_list);
        mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, mDatas);
        mCategories.setAdapter(mAdapter);
    }
}
