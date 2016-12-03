package me.acmh.sweaterweather.screens.citylist;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.data.City;
import me.acmh.sweaterweather.screens.cityinformation.CityInformationActivity;
import me.acmh.sweaterweather.screens.map.MapContract;


public class CityListFragment extends Fragment implements CityListContract.View, View.OnClickListener {

    private CityListContract.Presenter mPresenter;
    private CityListAdapter mCityListAdapter;
    private RecyclerView rv_cityList;
    private ProgressDialog progress;
    private static CityListFragment INSTANCE;

    public static CityListFragment getInstance() {
        if(INSTANCE == null){
            INSTANCE = new CityListFragment();
        }
        return INSTANCE;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.screen_city_list_fragment, container, false);
        rv_cityList = (RecyclerView) root.findViewById(R.id.rv_cities);
        rv_cityList.setLayoutManager(new LinearLayoutManager(getContext()));
        setAdapter();
        return root;
    }

    private void setAdapter(){
        if(mCityListAdapter == null){
            mCityListAdapter = new CityListAdapter(this);
        }
        rv_cityList.setAdapter(mCityListAdapter);
    }



    @Override
    public void onClick(View view) {
        int position = rv_cityList.getChildLayoutPosition(view);
        City c = mCityListAdapter.getCity(position);
        mPresenter.openCityDetails(c);
    }

    @Override
    public void setPresenter(CityListContract.Presenter presenter) {
        mPresenter = presenter;
    }



    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onLoadCityList(List<City> cities) {
        mCityListAdapter.setCityList(cities);

        dissmissDialogIfShowing();
    }

    @Override
    public void showCityInformationUI(City c) {
        Intent it = new Intent(getActivity(), CityInformationActivity.class);
        it.putExtra("name", c.getNome());
        it.putExtra("description", c.getWeatherDescription());
        it.putExtra("maxTemp", c.getMaxTemperature());
        it.putExtra("minTemp", c.getMinTemperature());
        startActivity(it);
    }

    @Override
    public void showLoading() {
        progress = ProgressDialog.show(getContext(), "Loading",
                "Fetching City List", true);

    }

    @Override
    public void onLoadCityListError() {
        dissmissDialogIfShowing();

        Snackbar.make(getView(),"There is no data for this location", Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void clearCityList() {
        mCityListAdapter.clearAll();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        dissmissDialogIfShowing();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    private void dissmissDialogIfShowing(){
        if(progress != null){
            progress.dismiss();
            progress = null;
        }
    }
}



