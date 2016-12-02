package me.acmh.sweaterweather.screens.citylist;

import java.util.List;

import me.acmh.sweaterweather.bases.BasePresenter;
import me.acmh.sweaterweather.bases.BaseView;
import me.acmh.sweaterweather.data.City;
import me.acmh.sweaterweather.screens.map.MapContract;


public interface CityListContract {
    interface View extends BaseView<CityListContract.Presenter> {
        void onLoadCityList(List<City> cities);
        void showCityInformationUI(City c);
        void showLoading();
        void onLoadCityListError();

    }

    interface Presenter extends BasePresenter {

        void openCityDetails(City c);

        void loadCityList();


    }
}
