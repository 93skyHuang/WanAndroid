package com.study.skyhuang.wanandroid.utils;

import android.util.Log;

/**
 * Created by skyHuang on 2018/11/9.
 */

public class LogUtils {

    private static boolean debug;

    public static void setDebugMode(boolean mode) {
        debug = mode;
    }

    public static void v(String tag, String msg) {
        if (debug) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (debug) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (debug) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (debug) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (debug) {
            Log.e(tag, msg);
        }
    }


}
