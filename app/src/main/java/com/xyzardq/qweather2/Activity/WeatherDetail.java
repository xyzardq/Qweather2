package com.xyzardq.qweather2.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.xyzardq.qweather2.HttpThread.HttpThreadSuggestion;
import com.xyzardq.qweather2.R;

public class WeatherDetail extends AppCompatActivity {


    private Handler handler = new Handler();

    public final static String EXTRA_MESSAGE = null;

    TextView weatherDetailName;

    TextView weatherDetailCW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        weatherDetailName = (TextView) findViewById(R.id.weatherDetailName);
        weatherDetailName.setText(message);

        weatherDetailCW = (TextView) findViewById(R.id.weatherDetailCW);

        new HttpThreadSuggestion(message,weatherDetailCW,handler).start();

    }
}
