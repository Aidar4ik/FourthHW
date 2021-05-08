package com.example.weatherapp.models;

import com.google.gson.annotations.SerializedName;

public class ModelWeather {

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
