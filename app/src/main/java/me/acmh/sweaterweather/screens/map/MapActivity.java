package me.acmh.sweaterweather.screens.map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.utils.ActivityUtils;

/**
 * Created by acmh on 01/12/2016.
 */

public class MapActivity extends AppCompatActivity {

    private static MapPresenter mapPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_map);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        ab.setTitle(R.string.title_activity_maps);


        MapFragment fragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if(fragment == null){
            fragment = MapFragment.getInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.content_frame);

        }
        if(mapPresenter == null) {
            mapPresenter = new MapPresenter(fragment, new MarkerOptions());
        }

        fragment.setPresenter(mapPresenter);
        mapPresenter.setView(fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean matched = true;
        switch(item.getItemId())
        {
            case R.id.radar_menu_btn:
                mapPresenter.onSearchClick();

                break;

            default:
                matched = false;
        }

        return matched;
    }

}
