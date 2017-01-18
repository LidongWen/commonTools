package com.wenld.commontools;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

/**
 * Created by wenld on 2016/3/3.
 * 复制粘贴工具类
 * SDK11以下建议不要用。。
 */
public class ClipboardUtils {
    private static ClipboardManager mClipboardManager;
    private static ClipboardManager mNewCliboardManager;

    private static void instance(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            if (mNewCliboardManager == null)
                mNewCliboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        } else {
            if (mClipboardManager == null)
                mClipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        }
    }

    /**
     * 为剪切板设置内容
     *
     * @param context
     * @param text
     */
    public static void copyFromEdit(Context context, CharSequence text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            instance(context);
            // Creates a new text clip to put on the clipboard
            ClipData clip = ClipData.newPlainText("simple text", text);//label为simple text
            // Set the clipboard's primary clip.
            mNewCliboardManager.setPrimaryClip(clip);
        } else {
            instance(context);
            mClipboardManager.setText(text);
        }
    }

    /**
     * 获取剪切板的内容
     *
     * @param context
     * @return
     */
    public static CharSequence pasteToResult(Context context) {
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            instance(context);
            if (!mNewCliboardManager.hasPrimaryClip()) {
//                Log.d("android.content.ClipboardManager", "Clipboard is empty");
                return sb.toString();
            } else {
                ClipData clipData = (mNewCliboardManager).getPrimaryClip();
                int count = clipData.getItemCount();
                for (int i = 0; i < count; ++i) {
                    ClipData.Item item = clipData.getItemAt(i);
                    CharSequence str = item.coerceToText(context);
                    Log.i("mengdd", "item : " + i + ": " + str);
                    sb.append(str);
                }
            }
        } else {
            instance(context);
            sb.append(mClipboardManager.getText());
        }
        return sb.toString();
    }
}