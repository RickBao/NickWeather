package com.example.library;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkUtils {

    /**
     * 判断网络连接是否可用
     */
    public static Boolean isNetworkConnected(Context context) {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}
