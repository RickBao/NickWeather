package com.example.myapplication.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.NickApplication;
import com.example.myapplication.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

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

    public static CityDatabaseHelper getInstance(Context context) {

        context = context.getApplicationContext();
        if (instance == null) {
            synchronized (CityDatabaseHelper.class) {
                if (instance == null) {
                    instance = new CityDatabaseHelper(context);
                }
            }
        }

        return instance;
    }

    @Override
    public void close() {
        super.close();
        DaoManager.clearCache();
    }

    public <D extends Dao<T, ?>, T> D getCityDao(Class<T> clazz) {
        try {
            return getDao(clazz);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 导入诚实数据库
     */
    public static void importCityDB() {

        //判断城市的数据库是否存在
        File file = new File(NickApplication.getInstance().getDatabasePath(DATABASE_NAME).getAbsolutePath());
        if (!file.exists()) {
            File dbFile = NickApplication.getInstance().getDatabasePath(DATABASE_NAME);
            try {
                if (!dbFile.getParentFile().exists()) {
                    dbFile.getParentFile().mkdir();
                }
                if (!dbFile.exists()) {
                    dbFile.createNewFile();
                }

                //加载导入的数据库
                InputStream is = NickApplication.getInstance().getResources().openRawResource(R.raw.city);
                FileOutputStream fos = new FileOutputStream(dbFile);
                byte[] buffer = new byte[is.available()];
                is.read(buffer);
                fos.write(buffer);
                is.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
