package com.example.weatherapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelForFifthDay {

    @SerializedName("main")
    private TempModel temp;

    @SerializedName("weather")
    private List<ModelWeather> weathers;

    @SerializedName("dt_txt")
    private String data;


    public TempModel getTemp() {
        return temp;
    }

    public void setTemp(TempModel temp) {
        this.temp = temp;
    }

    public List<ModelWeather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<ModelWeather> weathers) {
        this.weathers = weathers;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
