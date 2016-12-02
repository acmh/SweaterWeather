package me.acmh.sweaterweather.screens.citylist;

import java.util.List;

import me.acmh.sweaterweather.bases.BasePresenter;
import me.acmh.sweaterweather.bases.BaseView;
import me.acmh.sweaterweather.data.City;
import me.acmh.sweaterweather.screens.map.MapContract;


public interface CityListContract {
    interface View extends BaseView<CityListContract.Presenter> {
        void onLoadCityLst(List<City> cities);
        void showLoadingCityList(City c);
    }

    interface Presenter extends BasePresenter {

        void openCityDetails(City c);

        void loadCityList();


    }
}
