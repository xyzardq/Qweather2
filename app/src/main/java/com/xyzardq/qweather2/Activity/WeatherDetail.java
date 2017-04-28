package com.xyzardq.qweather2.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.xyzardq.qweather2.HttpThread.HttpThreadSuggestion;
import com.xyzardq.qweather2.R;

public class WeatherDetail extends AppCompatActivity {


    private Handler handler = new Handler();

    public final static String EXTRA_MESSAGE = null;

    String messagereal;

    TextView weatherDetailName;

    TextView weatherDetailCar;
    TextView weatherDetailDressing;
    TextView weatherDetailFlu;
    TextView weatherDetailSport;
    TextView weatherDetailTravel;
    TextView weatherDetailUv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        weatherDetailName = (TextView) findViewById(R.id.weatherDetailName);
        weatherDetailName.setText(message);

        weatherDetailCar = (TextView) findViewById(R.id.weatherDetailCar);
        weatherDetailDressing = (TextView) findViewById(R.id.weatherDetailDressing);
        weatherDetailFlu = (TextView) findViewById(R.id.weatherDetailFlu);
        weatherDetailSport = (TextView) findViewById(R.id.weatherDetailSport);
        weatherDetailTravel = (TextView) findViewById(R.id.weatherDetailTravel);
        weatherDetailUv = (TextView) findViewById(R.id.weatherDetailUv);

        try {
            messagereal = PinyinHelper.convertToPinyinString(message, "", PinyinFormat.WITHOUT_TONE);
        } catch (PinyinException e) {
            e.printStackTrace();
        }

        new HttpThreadSuggestion(messagereal,weatherDetailCar,weatherDetailDressing,weatherDetailFlu,weatherDetailSport,weatherDetailTravel,weatherDetailUv,handler).start();

    }
}
