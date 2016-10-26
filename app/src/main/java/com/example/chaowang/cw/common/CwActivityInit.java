package com.example.chaowang.cw.common;

/**
 * Created by chao.wang on 2016/10/25.
 */

public interface CwActivityInit {
    /**
     * Init The Activity
     */
    public void init();

    /**
     * Get The Intent Data
     */
    public void getIntentData();

    /**
     * Obtain The Object Of The View
     */
    public void initUI();

    /**
     * Init The Data
     */
    public void initData();

    /**
     * Put The OnClick Command Here
     */
    public void initOnClick();
}
