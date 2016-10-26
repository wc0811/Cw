package com.example.chaowang.cw;

import android.app.Application;
import android.content.Context;

/**
 * Author: chao.wang
 * CreateTime: 2016/10/24  11:07
 * Function:
 * Version: 1.0
 * -----------------------------------------------------------
 */

public class CwApplication extends Application {
    public static Context context;

    public static Context getContext() {
        return context;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        if (context == null) {//曾经测试出现同时启动多个Activity的现象

            context = this.getApplicationContext();

        }

    }

}
