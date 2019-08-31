package com.example.library.system;

import android.app.Activity;
import android.os.Build;
import android.view.View;

public class AndroidMHelper implements SystemHelper{


    @Override
    public boolean setStatusBarLightMode(Activity activity, boolean isFontColorDark) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isFontColorDark) {
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
            return true;
        }
        return false;
    }
}
