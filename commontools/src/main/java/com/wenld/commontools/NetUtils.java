package com.wenld.commontools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Vamoose on 2015/12/28.
 */
public class NetUtils {
    private final String URL_SPLITTER = "/";

    private NetUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断网络是否连接
     *
     * @param context
     * @return
     */
    public static boolean isConnected(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否是wifi连接
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm == null)
            return false;
        return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;

    }

    public static String Judgeurl(String weburl) {

        if (weburl == null) {
            return "";
        }
        if (weburl.length() > 0) {
            if (weburl.toLowerCase(Locale.ENGLISH).trim().indexOf("http://") < 0 && weburl.toLowerCase(Locale.ENGLISH).trim().indexOf("https://") < 0) {
                weburl = AllUtilConfig.Host_IP + weburl;
            }
        }
        return Uri.decode(weburl);
    }

    public static String Judgeurl(String weburl, String Host) {
        if (weburl == null) {
            return "";
        }
        if (weburl.length() > 0) {
            if (weburl.toLowerCase(Locale.ENGLISH).trim().indexOf("http://") < 0 && weburl.toLowerCase(Locale.ENGLISH).trim().indexOf("https://") < 0) {
                weburl = Host + weburl;
            }
        }
        return Uri.decode(weburl);
    }

    public static String UrlBuide(String mUrl, Map<String, String> mParamsMap) {
        Uri.Builder builder = Uri.parse(mUrl).buildUpon();
        Iterator<String> it = mParamsMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = mParamsMap.get(key);
            builder.appendQueryParameter(key, value);
        }
        return builder.toString();
    }

}
