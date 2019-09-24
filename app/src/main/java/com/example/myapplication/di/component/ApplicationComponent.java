package com.example.myapplication.di.component;

import android.content.Context;

import com.example.myapplication.NickApplication;
import com.example.myapplication.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    NickApplication getApplication();

    Context getContext();
}
