package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;
import com.example.weatherapp.databinding.ActivityMainBinding;
import com.example.weatherapp.models.Model;
import com.example.weatherapp.models.ModelForFifthDaySecond;
import com.example.weatherapp.retrofit.WeatherApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String cityName="Bishkek";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.cityName.setAdapter(adapter);
        binding.cityName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                WeatherApi.getInstance().getWeatherData(binding.cityName.getSelectedItem().toString(),"ru","metric").enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        binding.state.setText(response.body().getState());
                        binding.temp.setText(response.body().getTemp().getTemp() + "°");
                        binding.coulds.setText(response.body().getDescription().get(0).getDescription());
                Glide
                        .with(getApplicationContext())
                        .load("https://openweathermap.org/img/w/"+response.body().getDescription().get(0).getIcon()+".png")
                        .into(binding.cloudImg);
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        /*WeatherApi.getInstance().getNextDayData(binding.cityName.getText().toString().trim(),"ru","metric").enqueue(new Callback<ModelForFifthDaySecond>() {
            @Override
            public void onResponse(Call<ModelForFifthDaySecond> call, Response<ModelForFifthDaySecond> response) {
                Log.e("TAGS",response.body().getList().get(2).getData());
            }

            @Override
            public void onFailure(Call<ModelForFifthDaySecond> call, Throwable t) {

            }
        });*/


        //For Status Bar
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    //For Status Bar
    public static void setWindowFlag(Activity activity, final int bits, boolean on) {

        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}