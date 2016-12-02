package me.acmh.sweaterweather.screens.cityinformation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.screens.citylist.CityListContract;

public class CityInformationFragment extends Fragment implements CityInformationContract.View {

    private CityInformationContract.Presenter mPresenter;

    public static CityInformationFragment newInstance() {
        return new CityInformationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.screen_city_information_fragment, container, false);
        return root;
    }

    @Override
    public void setPresenter(CityInformationContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void onLoadCityInformation(String name, double max_temp, double min_temp, String description) {
        TextView tv_city_name = (TextView) getView().findViewById(R.id.tv_name);
        tv_city_name.setText(name);

        TextView tv_max_temp = (TextView) getView().findViewById(R.id.max_temp);
        tv_max_temp.setText(String.format("%.2f",max_temp)+"ºC");

        TextView tv_min_temp = (TextView) getView().findViewById(R.id.min_temp);
        tv_min_temp.setText(String.format("%.2f",min_temp) + "ºC");

        TextView tv_description = (TextView) getView().findViewById(R.id.description);
        tv_description.setText(description);


    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }
}
