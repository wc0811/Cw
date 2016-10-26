package com.example.chaowang.cw.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chaowang.cw.R;
import com.example.chaowang.cw.common.util.Util;


/**
 * Created by chao.wang on 2016/10/25.
 */

public class CommonTitle extends FrameLayout {
    /*
    * The Title
    * */
    private TextView tvTitle;
    private OnClickListener menuOnClickListener;
    private  Context mContext;

    public CommonTitle(Context context, OnClickListener menuOnClickListener) {
        super(context);
        this.mContext = context;
        this.menuOnClickListener = menuOnClickListener;


        LayoutParams LayParams = new LayoutParams(LayoutParams.MATCH_PARENT, Util.dip2px(context, 50));
        setLayoutParams(LayParams);
        this.setBackgroundColor(Color.parseColor("#148ce6"));

        tvTitle = new TextView(context);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        tvTitle.setGravity(Gravity.CENTER);
        tvTitle.setTextSize(24);
        tvTitle.setText("");
        tvTitle.setTextColor(Color.WHITE);
        this.addView(tvTitle);
    }


    protected void addBackButton() {

        Context context = this.getContext();

        ImageView ivBack = new ImageView(context);

        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.START | Gravity.CENTER;


        ivBack.setLayoutParams(lp);
        int padding = Util.dip2px(context, 10);
        ivBack.setPadding(padding, padding, padding, padding);
        ivBack.setImageResource(R.mipmap.ic_back);

        ivBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ( (Activity)getContext()).finish();
                ((Activity) getContext()).setResult(1);
            }
        });

        this.addView(ivBack);
    }

    protected void addMenuButton() {

        Context context = this.getContext();

        ImageView ivMenuBtn = new ImageView(context);

        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.END | Gravity.CENTER;

        ivMenuBtn.setLayoutParams(lp);
        int padding = Util.dip2px(context, 10);
        ivMenuBtn.setPadding(padding, padding, padding, padding);
        ivMenuBtn.setImageResource(R.mipmap.ic_menu);

        ivMenuBtn.setOnClickListener(menuOnClickListener);

        this.addView(ivMenuBtn);
    }

    protected void setCwTitle(String strTitle){

        tvTitle.setText(Util.checkString(strTitle));

    }
}
