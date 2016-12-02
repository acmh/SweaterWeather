package me.acmh.sweaterweather.data.openweathersource;


import java.util.ArrayList;
import java.util.List;

import me.acmh.sweaterweather.data.City;

public class OpenWeatherRepository implements OpenWeatherDataSource{

    private static OpenWeatherRepository INSTANCE = null;
    private final OpenWeatherDataSource mOpenWeatherRemoteDataSrc;

    public OpenWeatherRepository(OpenWeatherDataSource mOpenWeatherDataSrc) {
        this.mOpenWeatherRemoteDataSrc = mOpenWeatherDataSrc;
    }

    public static OpenWeatherRepository getInstance(OpenWeatherDataSource openWeatherRemoteDataSource){
        if(INSTANCE == null){
            INSTANCE = new OpenWeatherRepository(openWeatherRemoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void requestWeatherData(double lat, double lon, int count, String apiKey, final RequestWeatherDataCallback callback) {
        mOpenWeatherRemoteDataSrc.requestWeatherData(lat, lon, count, apiKey, new RequestWeatherDataCallback(){

            @Override
            public void onSucess(List<City> cities) {
                callback.onSucess(new ArrayList<City>(cities));
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }
}
