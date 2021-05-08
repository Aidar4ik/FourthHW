package com.example.weatherapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApi {

    private static WeatherApier instance;

    private WeatherApi(){}

    public static WeatherApier getInstance(){
        if(instance==null){
            instance=createRetrofit();
        }
        return instance;
    }

    private static WeatherApier createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApier.class);
    }
}
