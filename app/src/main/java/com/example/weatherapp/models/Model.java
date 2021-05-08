package com.example.weatherapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    @SerializedName("main")
    private TempModel temp;

    @SerializedName("name")
    private String state;

    @SerializedName("weather")
    private List<ModelWeather> description;

    public List<ModelWeather> getDescription() {
        return description;
    }

    public void setDescription(List<ModelWeather> description) {
        this.description = description;
    }

    public TempModel getTemp() {
        return temp;
    }

    public void setTemp(TempModel temp) {
        this.temp = temp;
    }

    public String getState() {
        return state;
    }
}
