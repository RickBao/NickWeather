package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.feature.MainActivity;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Observable.just(initAppData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> gotoHomePage());

    }

    private void gotoHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // 修复Android 9.0版本以下Activity 跳转动画导致的启动页闪屏的问题
        overridePendingTransition(0, 0);
        finish();
    }

    private String initAppData() {
        return null;
    }
}
