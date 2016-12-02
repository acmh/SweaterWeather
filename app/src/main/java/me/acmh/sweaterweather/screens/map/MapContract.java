package me.acmh.sweaterweather.screens.map;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import me.acmh.sweaterweather.bases.BasePresenter;
import me.acmh.sweaterweather.bases.BaseView;

/**
 * Created by acmh on 01/12/2016.
 */

public interface MapContract  {
    interface View extends BaseView<Presenter>{

    }

    interface Presenter extends BasePresenter{
        void setOnMapClickListener(GoogleMap.OnMapClickListener listener);
        void setMarkerPosition(LatLng latLng);
        void onMapReadyCallback(GoogleMap googleMap);
        void onSearchClickCallback();
    }
}
