package me.acmh.sweaterweather.screens.citylist;

import java.util.List;

import me.acmh.sweaterweather.bases.BasePresenter;
import me.acmh.sweaterweather.bases.BaseView;
import me.acmh.sweaterweather.data.City;
import me.acmh.sweaterweather.screens.map.MapContract;

/**
 * Created by acmh on 02/12/2016.
 */

public interface CityListContract {
    interface View extends BaseView<CityListContract.Presenter> {
        void onLoadCityLst(List<City> cities);
        void showLoadingCityList();
    }

    interface Presenter extends BasePresenter {

        void openCityDetails(City c);

        void loadCityList();


    }
}
