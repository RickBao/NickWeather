package com.example.library.system;

import android.app.Activity;
import android.view.Window;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MIUIHelper implements SystemHelper{


    /**
     * 设置状态栏字体图标为深色，需要MIUI 6 以上
     * @param isFontColorDark 是否把状态栏字体及图标颜色设置为深色
     * @return Boolean 成功执行返回true
     */
    @Override
    public boolean setStatusBarLightMode(Activity activity, boolean isFontColorDark) {

        Window window = activity.getWindow();
        boolean result = false;

        if (window != null) {
            Class clazz = window.getClass();
            try {

                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (isFontColorDark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);  //状态栏透明并且字体黑色
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);     //清除黑色字体
                }
                result = true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}
