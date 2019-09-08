package com.example.myapplication.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

public class CityDatabaseHelper extends OrmLiteSqliteOpenHelper {


    private static final String TAG = "CityDatabaseHelper";

    private static final String DATABASE_NAME = "city.db";
    private static final int DATABASE_VERSION = 1;

    private static volatile CityDatabaseHelper instance;

    public CityDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        //由于城市数据库是由外部导入的，故不需要创建执行创建表的操作
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    
}
