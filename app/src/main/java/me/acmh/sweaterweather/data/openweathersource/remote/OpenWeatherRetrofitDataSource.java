package me.acmh.sweaterweather.data.openweathersource.remote;

import me.acmh.sweaterweather.data.openweathersource.remote.retrofitmodel.OpenWeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OpenWeatherRetrofitDataSource {

    @GET("data/2.5/find")
    Call<OpenWeatherResponse> getOctopusRespostas(@Path("lat") double lat,
                                                  @Path("lon") double lon,
                                                  @Path("cnt") int cnt,
                                                  @Path("appid")String apikey);

}
