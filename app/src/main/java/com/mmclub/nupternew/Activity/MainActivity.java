package com.mmclub.nupternew.Activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.mmclub.nupternew.R;
import com.mmclub.nupternew.fragment.FragmentFactory;
import com.mmclub.nupternew.fragment.left_side_menu.LeftMenu;
import com.mmclub.nupternew.fragment.main.MainFragment;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends SlidingFragmentActivity {
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;
    private ImageButton MenuButton;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initLeftMenu();
        JPushInterface.init(this);
        MenuButton=(ImageButton)this.findViewById(R.id.menu_button);

        fragmentManager = getFragmentManager();
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = FragmentFactory.getInstanceByIndex(R.id.tag1);
        transaction.replace(R.id.content, fragment);
        transaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment fragment = FragmentFactory.getInstanceByIndex(checkedId);
                transaction.replace(R.id.content, fragment);
                transaction.commit();
            }
        });

        MenuButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                getSlidingMenu().showMenu();
                        }
        });
    }
    private void initLeftMenu(){
        LeftMenu leftMenuFragment = new LeftMenu();
        setBehindContentView(R.layout.left_menu);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.side_menu, leftMenuFragment).commit();
        SlidingMenu menu = getSlidingMenu();
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        menu.setSecondaryShadowDrawable(R.drawable.shadow);
    }
    public void showLeftMenu(View view) {
        getSlidingMenu().showMenu();
    }
    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private void init() {
        JPushInterface.init(getApplicationContext());
    }
}
