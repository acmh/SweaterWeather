package me.acmh.sweaterweather.screens.map;

import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.bases.BaseView;


public class MapPresenter implements MapContract.Presenter {
    private GoogleMap mMap;
    MarkerOptions markerOptions;
    Marker marker;
    MapContract.View mView;

    MapPresenter(MapContract.View v, MarkerOptions markerOptions){
        this.mView = v;
        mView.setPresenter(this);
        this.markerOptions = markerOptions;
    }

    @Override
    public void start() {
        //CHAMAR AS FUNCOES DE BACKEND
    }

    @Override
    public void setView(BaseView view) {
        mView = (MapContract.View) view;
    }

    @Override
    public void setOnMapClickListener(GoogleMap.OnMapClickListener listener) {
        mMap.setOnMapClickListener(listener);
    }

    @Override
    public void setMarkerPosition(LatLng latLng) {
        if(marker != null) marker.remove();
        markerOptions.position(latLng).title("Current Position");
        marker= mMap.addMarker(markerOptions);
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng),400,null);
    }

    @Override
    public void onMapReadyCallback(GoogleMap googleMap) {
        mMap = googleMap;
        //If marker is initialized add it to the map
        if(marker != null){

            marker = mMap.addMarker(markerOptions);
            mMap.animateCamera(CameraUpdateFactory.newLatLng(markerOptions.getPosition()),400,null);
        }

    }

    @Override
    public void onSearchClickCallback() {
        
    }


}
