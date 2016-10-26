package com.example.chaowang.cw.common;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * Created by chao.wang on 2016/10/25.
 */

public class BaseActivity extends FragmentActivity implements CwActivityInit {
    private CommonTitle commonTitle;
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        initTitle();
    }

    private void initTitle() {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);


        LinearLayout lBar = new LinearLayout(this);
        LinearLayout.LayoutParams lpBar = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        lBar.setLayoutParams(lpBar);
        lBar.setOrientation(LinearLayout.VERTICAL);
        lBar.setBackgroundColor(Color.parseColor("#148ce6"));
        lBar.setFitsSystemWindows(true);
        lBar.setClipToPadding(true);


        commonTitle = new CommonTitle(this, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickMenu();
            }
        });


        RelativeLayout rContent = new RelativeLayout(this);
        ViewGroup.LayoutParams rContentLp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rContent.setLayoutParams(rContentLp);
        rContent.setBackgroundColor(Color.WHITE);

        View view = View.inflate(context, layoutResID, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);


        lBar.addView(commonTitle);
        lBar.addView(rContent);

        setContentView(lBar);
        init();
    }

    protected void setCwTitle(String strTitle) {
        commonTitle.setCwTitle(strTitle);
    }

    protected void addMenuButton() {
        commonTitle.addMenuButton();
    }

    protected void addBackButton() {
        commonTitle.addBackButton();
    }


    protected void onClickMenu() {
    }

    @Override
    public void init() {
        getIntentData();
        initUI();
        initData();
        initOnClick();
    }

    @Override
    public void getIntentData() {

    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {
        initList();
    }

    @Override
    public void initOnClick() {

    }

    private void initList() {
    }

}
