package me.acmh.sweaterweather.screens.map;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import me.acmh.sweaterweather.bases.BasePresenter;
import me.acmh.sweaterweather.bases.BaseView;



public interface MapContract  {
    interface View extends BaseView<Presenter>{
        void showCityListUI(LatLng latLng);
        void showMessage(String text);
    }

    interface Presenter extends BasePresenter{
        void setOnMapClickListener(GoogleMap.OnMapClickListener listener);
        void setMarkerPosition(LatLng latLng);
        void onMapReadyCallback(GoogleMap googleMap);
        void onSearchClick();
    }
}
