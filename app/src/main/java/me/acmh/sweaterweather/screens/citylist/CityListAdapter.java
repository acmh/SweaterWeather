package me.acmh.sweaterweather.screens.citylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.acmh.sweaterweather.R;
import me.acmh.sweaterweather.data.City;

/**
 * Created by acmh on 02/12/2016.
 */

public class CityListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final ArrayList<City> mCities;
    private final View.OnClickListener mOnClickListener;

    public CityListAdapter(View.OnClickListener listener) {
        mCities = new ArrayList<City>();
        mOnClickListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cities, parent, false);
        v.setOnClickListener(mOnClickListener);
        CityHolder ch = new CityHolder(v);
        return ch;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CityHolder ch = (CityHolder) holder;
        City c = mCities.get(position);
        ch.tv_cityName.setText(c.getNome());
        //TODO Set respective weather icon
    }

    public void setCityList(List<City> cities) {
        mCities.clear();
        mCities.addAll(cities);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    public City getCity(int position){
        return mCities.get(position);
    }

    class CityHolder extends RecyclerView.ViewHolder{
        public ImageView iv_thumb;
        public TextView tv_cityName;

        public CityHolder(View itemView){
            super(itemView);
            iv_thumb = (ImageView) itemView.findViewById(R.id.weather_icon);
            tv_cityName = (TextView) itemView.findViewById(R.id.city_name);
        }
    }
}
