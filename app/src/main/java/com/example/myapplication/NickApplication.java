package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.myapplication.di.component.ApplicationComponent;
import com.example.myapplication.di.component.DaggerApplicationComponent;
import com.example.myapplication.di.module.ApplicationModule;

public class NickApplication extends Application {

    private static final String TAG = "NickWeatherApplication";
    private ApplicationComponent applicationComponent;
    private static NickApplication nickApplication;

    public static NickApplication getInstance() {
        return nickApplication;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.e(TAG, "attach Base context");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {

        }

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        nickApplication = this;

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
