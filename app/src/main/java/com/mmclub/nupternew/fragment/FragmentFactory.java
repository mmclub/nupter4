package com.mmclub.nupternew.fragment;

import android.app.Fragment;

import com.mmclub.nupternew.R;
import com.mmclub.nupternew.fragment.main.MainFragment;
import com.mmclub.nupternew.fragment.timetable.TimeTableFragment;

/**
 * Created by J on 15/10/25.
 */
public class FragmentFactory{
    public static Fragment getInstanceByIndex(int index) {
        Fragment fragment = null;
        switch (index) {
            case R.id.tag1:
                fragment = new MainFragment();
                break;
            case R.id.tag2:
                fragment = new TimeTableFragment();
                break;

        }
        return fragment;
    }
}
