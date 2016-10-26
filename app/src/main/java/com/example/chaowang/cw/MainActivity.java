package com.example.chaowang.cw;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.chaowang.cw.common.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initData() {
        super.initData();
        setCwTitle(context.getResources().getString(R.string.app_test_title));
        addBackButton();
        addMenuButton();
    }

    @Override
    protected void onClickMenu() {
        super.onClickMenu();
        Toast.makeText(context, context.getResources().getString(R.string.app_test_click_menu), Toast.LENGTH_SHORT).show();
    }
}
