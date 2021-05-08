package com.example.weatherapp.retrofit;

import android.view.Display;

import com.example.weatherapp.models.Model;
import com.example.weatherapp.models.ModelForFifthDaySecond;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApier {

    @GET("weather?appid=909f34aee6e3b6140b5e03f501dc118e")
    Call<Model> getWeatherData(@Query("q") String name,
                               @Query("lang") String lang,
                               @Query("units") String units);

    @GET("forecast?appid=909f34aee6e3b6140b5e03f501dc118e")
    Call<ModelForFifthDaySecond> getNextDayData(@Query("q") String name,
                                                @Query("lang") String lang,
                                                @Query("units") String units);
}
