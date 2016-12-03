package me.acmh.sweaterweather.data.openweathersource.remote.retrofitmodel;

import com.google.gson.annotations.SerializedName;

public class OpenWeatherResponse {
    public String message;
    public String cod;
    public int count;
    @SerializedName("list")
    public ServerResponseCity[] cityList;
}
