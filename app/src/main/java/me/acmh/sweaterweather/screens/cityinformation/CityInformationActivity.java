package me.acmh.sweaterweather.screens.cityinformation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.screens.citylist.CityListFragment;
import me.acmh.sweaterweather.utils.ActivityUtils;

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

        //Get from intent the values
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        double max_temp = getIntent().getDoubleExtra("maxTemp", 0.0);
        double min_temp = getIntent().getDoubleExtra("minTemp",0.0);

        new CityInformationPresenter(name,max_temp, min_temp,description,fragment);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
