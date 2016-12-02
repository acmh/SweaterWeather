package me.acmh.sweaterweather.data.openweathersource;

import java.util.List;

import me.acmh.sweaterweather.data.City;

/**
 * Created by acmh on 02/12/2016.
 */

public interface OpenWeatherDataSource {
    interface RequestWeatherDataCallback{
        void onSucess(List<City> cities);
        void onError();
    }

    void requestWeatherData(double lat, double lon, int count, String apiKey, RequestWeatherDataCallback callback);
}
