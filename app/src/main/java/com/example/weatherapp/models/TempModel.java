package com.example.weatherapp.models;

import com.google.gson.annotations.SerializedName;

public class TempModel {
    @SerializedName("temp")
    private String temp;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
