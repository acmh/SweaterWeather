package me.acmh.sweaterweather.screens.map;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.screens.citylist.CityListActivity;

public class MapFragment extends Fragment implements MapContract.View, GoogleMap.OnMapClickListener, OnMapReadyCallback {
    private static MapFragment mInstance;
    private MapContract.Presenter mPresenter;

    @Override
    public void setPresenter(MapContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public static MapFragment getInstance(){
        if(mInstance == null){
            mInstance = new MapFragment();
        }
        return mInstance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.screen_map_fragment, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return root;

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();


    }

    @Override
    public void onMapClick(LatLng latLng) {
        mPresenter.setMarkerPosition(latLng);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mPresenter.onMapReadyCallback(googleMap);
        mPresenter.setOnMapClickListener(this);
    }

    @Override
    public void showCityListUI(LatLng latLng) {
        Intent it = new Intent(getActivity(), CityListActivity.class);
        it.putExtra("lat", latLng.latitude);
        it.putExtra("lon", latLng.longitude);
        startActivity(it);
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(getContext(),text, Toast.LENGTH_SHORT).show();
    }
}
