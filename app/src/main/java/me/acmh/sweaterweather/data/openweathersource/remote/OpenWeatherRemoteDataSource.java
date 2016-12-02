package me.acmh.sweaterweather.data.openweathersource.remote;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

import me.acmh.sweaterweather.data.City;
import me.acmh.sweaterweather.data.openweathersource.OpenWeatherDataSource;
import me.acmh.sweaterweather.data.openweathersource.remote.retrofitmodel.OpenWeatherResponse;
import me.acmh.sweaterweather.data.openweathersource.remote.retrofitmodel.ServerResponseCity;
import me.acmh.sweaterweather.utils.OpenWeatherUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by acmh on 02/12/2016.
 */

public class OpenWeatherRemoteDataSource implements OpenWeatherDataSource{
    private static final String BASE_URL = OpenWeatherUtils.BASE_URL;
    private final Context mContext;
    private final Retrofit retrofit;
    private final OpenWeatherRetrofitDataSource remoteRepo;
    private static OpenWeatherRemoteDataSource INSTANCE;

    public OpenWeatherRemoteDataSource(Context mContext) {
        this.mContext = mContext;

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        remoteRepo = retrofit.create(OpenWeatherRetrofitDataSource.class);


    }

    public static OpenWeatherRemoteDataSource getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new OpenWeatherRemoteDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void requestWeatherData(double lat, double lon, int count, String apiKey, final RequestWeatherDataCallback callback) {
        Call<OpenWeatherResponse> call = remoteRepo.getCityList(lat, lon,count, apiKey);
        call.enqueue(new Callback<OpenWeatherResponse>() {
            @Override
            public void onResponse(Call<OpenWeatherResponse> call, Response<OpenWeatherResponse> response) {
                switch (response.code()){
                    case 200:
                        ArrayList<City> cityList = new ArrayList<City>();
                        for (ServerResponseCity c : response.body().cityList){
                            cityList.add(new City(c.name, c.temperature.temp_max, c.temperature.temp_min, c.weather[0].description));
                        }
                        callback.onSucess(cityList);
                        break;

                    default:
                        callback.onError();
                }

            }

            @Override
            public void onFailure(Call<OpenWeatherResponse> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
