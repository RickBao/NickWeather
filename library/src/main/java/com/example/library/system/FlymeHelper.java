package com.example.library.system;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;

public class FlymeHelper implements SystemHelper{


    /**
     * 设置状态栏图标为深色和魅族特定的文字风格
     * 可以用来判断是否为Flyme用户
     *
     * @param isFontColorDark   是否把状态栏字体及图标颜色设置为深色
     * @return Boolean 成功执行返回 true
     */
    @Override
    public boolean setStatusBarLightMode(Activity activity, boolean isFontColorDark) {

        Window window = activity.getWindow();
        boolean result = false;

        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field flymeFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");

                darkFlag.setAccessible(true);
                flymeFlags.setAccessible(true);

                int bit = darkFlag.getInt(null);
                int value = flymeFlags.getInt(lp);

                if (isFontColorDark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }

                flymeFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
