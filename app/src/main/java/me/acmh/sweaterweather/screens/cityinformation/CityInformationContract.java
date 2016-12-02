package me.acmh.sweaterweather.screens.cityinformation;

import me.acmh.sweaterweather.bases.BasePresenter;
import me.acmh.sweaterweather.bases.BaseView;


public interface CityInformationContract {
    interface View extends BaseView<CityInformationContract.Presenter>{
        void onLoadCityInformation(String name, double max_temp, double min_temp, String description);
    }

    public interface Presenter extends BasePresenter {

    }
}
