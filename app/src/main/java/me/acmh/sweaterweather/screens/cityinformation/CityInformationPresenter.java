package me.acmh.sweaterweather.screens.cityinformation;


import me.acmh.sweaterweather.bases.BaseView;


public class CityInformationPresenter implements CityInformationContract.Presenter {
    private final String name;
    private final double max_temp;
    private final double min_temp;
    private final String description;
    private final CityInformationContract.View mView;

    public CityInformationPresenter(String name, double max_temp, double min_temp, String description, CityInformationContract.View mView){
        this.name = name;
        this.max_temp = max_temp;
        this.min_temp = min_temp;
        this.description = description;
        this.mView = mView;
    }

    @Override
    public void start() {
        loadCityInformation();
    }

    public void loadCityInformation(){
        mView.onLoadCityInformation(name, max_temp, min_temp, description);
    }

    @Override
    public void setView(BaseView view) {

    }
}
