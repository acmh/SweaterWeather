package me.acmh.sweaterweather.screens.cityinformation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.screens.citylist.CityListFragment;
import me.acmh.sweaterweather.utils.ActivityUtils;

/**
 * Created by acmh on 02/12/2016.
 */

public class CityInformationActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_city_information);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        CityInformationFragment fragment = (CityInformationFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (fragment == null ){
            fragment = CityInformationFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.content_frame);
        }

        //PEGAR DA INTENT OS VALORES NECESSARIOS
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        double max_temp = getIntent().getDoubleExtra("maxTemp", 0.0);
        double min_temp = getIntent().getDoubleExtra("minTemp",0.0);

        new CityInformationPresenter(name,max_temp, min_temp,description,fragment);


    }
}
