package com.qingmang.baselibrary.utils;

import android.util.Log;



public class LogManager {

    private static final String TAG = "YUEDAREN";
    public static final boolean DEBUG = AppUtils.isDebug();
    public static void i(String msg){
        if(DEBUG){
            Log.i(TAG, msg);
        }
    }
    public static void d(String msg){
        if(DEBUG){
            Log.d(TAG, msg);
        }
    }
    public static void e(String msg){
        if(DEBUG){
            Log.e(TAG, msg);
        }
    }

    public static void i(String tag, String msg){
        if(DEBUG){
            Log.i(tag, msg);
        }
    }
    public static void d(String tag, String msg){
        if(DEBUG){
            Log.d(tag, msg);
        }
    }
    public static void e(String tag, String msg){
        if(DEBUG){
            Log.e(tag, msg);
        }
    }
}
