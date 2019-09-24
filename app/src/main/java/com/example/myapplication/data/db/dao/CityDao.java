package com.example.myapplication.data.db.dao;

import android.content.Context;

import com.example.myapplication.data.db.CityDatabaseHelper;
import com.example.myapplication.data.db.entities.City;
import com.example.myapplication.data.db.entities.HotCity;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.query.In;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

/**
 * City 操作类
 */
public class CityDao {

    private Dao<City, Integer> cityDaoOperation;
    private Dao<HotCity, Integer> hotCityOperation;

    @Inject
    CityDao(Context context) {
        this.cityDaoOperation = CityDatabaseHelper.getInstance(context).getCityDao(City.class);
        this.hotCityOperation = CityDatabaseHelper.getInstance(context).getCityDao(HotCity.class);
    }

    /**
     * 查询表中的所有城市
     * @return
     */
    public List<City> queryCityList() {
        try {
            return cityDaoOperation.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据城市ID查询城市信息
     * @param cityId 城市ID
     * @return city
     * @throws SQLException
     */
    public City queryCityById(String cityId) throws SQLException {

        QueryBuilder<City, Integer> queryBuilder = cityDaoOperation.queryBuilder();
        queryBuilder.where().eq(City.CITY_ID_FIELD_NAME, cityId);
        return queryBuilder.queryForFirst();
    }

    /**
     * 查询所有热门城市
     * @return 热门城市列表
     */
    public List<HotCity> queryAllHotcity() {
        try {
            return hotCityOperation.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
