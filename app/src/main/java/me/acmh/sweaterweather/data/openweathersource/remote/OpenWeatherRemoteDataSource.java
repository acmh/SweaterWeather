package me.acmh.sweaterweather.data.openweathersource.remote;

import android.content.Context;

import java.io.IOException;

import me.acmh.sweaterweather.data.openweathersource.OpenWeatherDataSource;
import me.acmh.sweaterweather.utils.OpenWeatherUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
    public void requestWeatherData(double lat, double lon, int count, String apiKey, RequestWeatherDataCallback callback) {

    }
}
