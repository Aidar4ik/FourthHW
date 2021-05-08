package com.example.weatherapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelForFifthDaySecond {

    @SerializedName("list")
    private List<ModelForFifthDay> list;

    public List<ModelForFifthDay> getList() {
        return list;
    }

    public void setList(List<ModelForFifthDay> list) {
        this.list = list;
    }
}
