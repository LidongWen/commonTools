package com.wenld.commontools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by Vamoose on 2015/9/16.
 */
public class ScreenUtils {
    private static final String TAG = ScreenUtils.class.getSimpleName();

    /**
     * 用于获取状态栏的高度。
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Activity activity) {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return activity.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            //LogHelper.e("Exception", "*****EXCEPTION*****\n", e);
        }
        return 0;
    }

    /**
     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取标题栏高度
     *
     * @param activity
     * @return
     */
    public static int getTitleBarHeight(Activity activity) {
        int contentTop = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
        return contentTop - getStatusBarHeight(activity);
    }

    /**
     * 在Activity中获取屏幕的高度和宽度
     *
     * @param activity 在真机中，有时候会发现得到的尺寸不是很准确，需要在AndroidManifest中添加如下配置：
     *                 <supports-screens android:smallScreens="true"
     *                 android:normalScreens="true" android:largeScreens="true"
     *                 android:resizeable="true" android:anyDensity="true" />
     */
    public static int[] getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return new int[]{
                point.x, point.y
        };
    }

    /**
     * 获取屏幕宽度和高度，单位为px
     *
     * @param context
     * @return
     */
    public static Point getScreenMetrics(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        return new Point(w_screen, h_screen);

    }

    /**
     * 获取屏幕长宽比
     *
     * @param context
     * @return 比例值
     */
    public static float getScreenRate(Context context) {
        Point P = getScreenMetrics(context);
        float H = P.y;
        float W = P.x;
        return (H / W);
    }

    /**
     * 在非Activity中，通常会在Custom View时
     * 目前不推荐使用（3.2及以下）
     *
     * @param context 在真机中，有时候会发现得到的尺寸不是很准确，需要在AndroidManifest中添加如下配置：
     *                <supports-screens android:smallScreens="true"
     *                android:normalScreens="true" android:largeScreens="true"
     *                android:resizeable="true" android:anyDensity="true" />
     */
    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return new int[]{
                dm.widthPixels, dm.heightPixels
        };

    }

    // 根据屏幕密度转换
    private static float mPixels = 0.0F;
    private static float density = -1.0F;

    /**
     * @param context
     * @param pixels
     * @return
     */
    public static int getDisplayMetrics(Context context, float pixels) {
        if (mPixels == 0.0F)
            mPixels = context.getResources().getDisplayMetrics().density;
        return (int) (0.5F + pixels * mPixels);
    }

    public static int getImageWeidth(Context context, float pixels) {
        return context.getResources().getDisplayMetrics().widthPixels - 66 - getDisplayMetrics(context, pixels);
    }

    /**
     * @param context
     * @param height
     * @return
     */
    public static int getMetricsDensity(Context context, float height) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getMetrics(localDisplayMetrics);
        return Math.round(height * localDisplayMetrics.densityDpi / 160.0F);
    }

    public static int fromDPToPix(Context context, int dp) {
        return Math.round(getDensity() * dp);
    }


    public static float getDensity() {
        density = Resources.getSystem().getDisplayMetrics().density;
        return density;
    }

    public static int round(Context context, int paramInt) {
        return Math.round(paramInt / getDensity());
    }

    /**
     * 像素转化dip
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * dip转化像素
     *
     * @param dipValue
     * @return
     */
    public static int dip2px(float dipValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);

    }

    /**
     * sp转px
     *
     * @param context
     * @param spVal
     * @return
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * px转sp
     *
     * @param context
     * @param pxVal
     * @return
     */
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }
}
