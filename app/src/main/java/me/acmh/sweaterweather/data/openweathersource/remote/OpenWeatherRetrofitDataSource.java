package me.acmh.sweaterweather.data.openweathersource.remote;

import me.acmh.sweaterweather.data.openweathersource.remote.retrofitmodel.OpenWeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenWeatherRetrofitDataSource {

    @GET("data/2.5/find?")
    Call<OpenWeatherResponse> getCityList(@Query("lat") double lat,
                                          @Query("lon") double lon,
                                          @Query("cnt") int cnt,
                                          @Query("appid")String apikey);

}
