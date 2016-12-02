package me.acmh.sweaterweather.screens.citylist;

import android.util.Log;

import java.util.List;

import me.acmh.sweaterweather.BuildConfig;
import me.acmh.sweaterweather.bases.BaseView;
import me.acmh.sweaterweather.data.City;
import me.acmh.sweaterweather.data.openweathersource.OpenWeatherDataSource;
import me.acmh.sweaterweather.data.openweathersource.OpenWeatherRepository;
import me.acmh.sweaterweather.utils.OpenWeatherUtils;

/**
 * Created by acmh on 02/12/2016.
 */

public class CityListPresenter implements CityListContract.Presenter {
    private final OpenWeatherRepository mRepository;
    private CityListContract.View mView;
    private final String mApiKey;
    private final double lat;
    private final double lon;
    private static CityListPresenter INSTANCE;

    private CityListPresenter(OpenWeatherRepository mRepository, CityListContract.View mView, double lat, double lon) {
        this.mRepository = mRepository;
        this.mView = mView;
        mView.setPresenter(this);
        this.mApiKey = BuildConfig.API_KEY_OWMAP;
        this.lat = lat;
        this.lon = lon;
    }

    public static void init(OpenWeatherRepository mRepository, CityListContract.View mView, double lat, double lon){
        INSTANCE = new CityListPresenter(mRepository,mView, lat, lon);
    }

    public static CityListPresenter getInstance(CityListContract.View mView){
        if(INSTANCE != null){
            INSTANCE.setView(mView);
            mView.setPresenter(INSTANCE);
        }
        return INSTANCE;
    }


    @Override
    public void start() {
        mView.showLoading();
        loadCityList();
    }

    @Override
    public void loadCityList() {
        mRepository.requestWeatherData(lat, lon, OpenWeatherUtils.RESULT_COUNT, mApiKey, new OpenWeatherDataSource.RequestWeatherDataCallback() {
            @Override
            public void onSucess(List<City> cities) {
                mView.onLoadCityList(cities);
            }

            @Override
            public void onError() {
                mView.onLoadCityListError();
            }
        });

    }

    @Override
    public void setView(BaseView view) {
        mView = (CityListContract.View) view;
    }



    @Override
    public void openCityDetails(City c) {

        mView.showCityInformationUI(c);
    }
}
