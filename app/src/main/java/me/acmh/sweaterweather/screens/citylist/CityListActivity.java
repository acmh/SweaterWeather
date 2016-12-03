package me.acmh.sweaterweather.screens.citylist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.data.openweathersource.OpenWeatherRepository;
import me.acmh.sweaterweather.data.openweathersource.remote.OpenWeatherRemoteDataSource;
import me.acmh.sweaterweather.utils.ActivityUtils;

public class CityListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_city_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        CityListFragment fragment = (CityListFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (fragment == null ){
            fragment = CityListFragment.getInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.content_frame);
        }

        OpenWeatherRepository repositoryInstance  = OpenWeatherRepository.getInstance(OpenWeatherRemoteDataSource.getInstance(getApplicationContext()));
        double lat = getIntent().getDoubleExtra("lat",0.0);
        double lon = getIntent().getDoubleExtra("lon", 0.0);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(2)
                .defaultDisplayImageOptions(new DisplayImageOptions.Builder()
                        .showImageOnLoading(android.R.drawable.ic_menu_rotate)
                        .showImageOnFail(android.R.drawable.ic_menu_help)
                        .cacheInMemory(true)
                        .cacheOnDisk(false)
                        .build())
                .build();

        ImageLoader.getInstance().init(config);

        if(CityListPresenter.getInstance(fragment) == null){
            CityListPresenter.init(repositoryInstance, fragment, lat, lon);
        }
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

    @Override
    public void onBackPressed() {
        CityListPresenter.invalidateInstance();
        super.onBackPressed();

    }
}
