package com.mmclub.nupternew.fragment;

/**
 * Created by J on 15/10/25.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mmclub.nupternew.R;

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttest, null);
        TextView textView = (TextView) view.findViewById(R.id.text_test);
        textView.setText(initContent());

        return view;
    }
    public abstract String initContent();


}
