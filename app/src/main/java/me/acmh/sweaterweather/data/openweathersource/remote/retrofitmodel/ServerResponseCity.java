package me.acmh.sweaterweather.data.openweathersource.remote.retrofitmodel;

import com.google.gson.annotations.SerializedName;


public class ServerResponseCity {
    public long id;
    public String name;
    @SerializedName("dt")
    public long timestamp;
    public ServerResponseCoordinates coord;
    @SerializedName("main")
    public ServerResponseTemperatures temperature;
    public ServerResponseWind wind;
    public ServerResponseSys sys;
    public ServerResponseClouds clouds;
    public ServerResponseWeather[] weather;


    public class ServerResponseCoordinates{
        public double lon;
        public double lat;
    }

    public class ServerResponseTemperatures{
        public double temp;
        public double temp_min;
        public double temp_max;
        public double pressure;
        public double sea_level;
        public double grnd_level;
        public int humidity;
    }

    public class ServerResponseWind{
        public double speed;
        public double deg;
    }

    public class ServerResponseSys{
        public String country;
    }

    public class ServerResponseClouds{
        public int all;
    }

    public class ServerResponseWeather{
        public long id;
        public String main;
        public String description;
        public String icon;
    }



}
