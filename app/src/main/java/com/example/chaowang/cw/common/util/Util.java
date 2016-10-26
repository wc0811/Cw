package com.example.chaowang.cw.common.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.chaowang.cw.CwApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chao.wang
 * 
 * @FileName: Util
 * 
 * @Description: WSDPro Util
 * 
 * @Createdate: 2016年6月16日 14:22:12
 * 
 * @version:1.0 Modification History: Date Author Version Description
 * 
 *              ----------------------------------------------------------------
 */
public class Util {

	public static int dip2px(Context context, float dpValue) {

		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);

	}

	public static int px2dip(Context context, float pxValue) {

		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);

	}




	@SuppressLint("ClickableViewAccessibility")
	public static void hideSoftInput(final Context context, View view) {

		final InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

		view.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					if (((Activity) context).getCurrentFocus() != null) {
						if (((Activity) context).getCurrentFocus().getWindowToken() != null) {
							imm.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(),
									InputMethodManager.HIDE_NOT_ALWAYS);
						}
					}
				}
				return false;
			}
		});
	}

	@SuppressLint("SimpleDateFormat")
	public static String getSysCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());
		String CurTime = formatter.format(curDate);
		return CurTime;
	}


	public static String checkString(String pItem) {

		String str = "";
		if (!TextUtils.isEmpty(pItem)) {
			str = pItem;
		}

		return str;
	}

	public static int str2Int(String pItem) {
		int itemp = 0;

		if (!TextUtils.isEmpty(pItem)) {

			try {
				itemp = Integer.valueOf(pItem);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		return itemp;
	}

	public static String getVersionCode() {

		try {

			PackageManager tManager = CwApplication.getContext().getPackageManager();
			PackageInfo tInfo = tManager.getPackageInfo(CwApplication.getContext().getPackageName(), 0);
			return String.valueOf(tInfo.versionCode);

		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}

}
