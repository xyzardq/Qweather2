package com.xyzardq.qweather2.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xyzardq.qweather2.R;

public class WeatherCity extends AppCompatActivity {


    private Handler handler = new Handler();

    public final static String EXTRA_MESSAGE = null;

    TextView weatherCityName;

    public void Detail(View view) {
        Intent intentOld = getIntent();
        String message = intentOld.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Intent intent = new Intent(this, WeatherDetail.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_city);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        weatherCityName = (TextView) findViewById(R.id.weatherCityName);
        weatherCityName.setText(message);


    }
}
