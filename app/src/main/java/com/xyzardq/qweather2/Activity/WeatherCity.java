package com.xyzardq.qweather2.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.xyzardq.qweather2.HttpThread.HttpThreadDaily;
import com.xyzardq.qweather2.R;


public class WeatherCity extends AppCompatActivity {


    private Handler handler = new Handler();

    public final static String EXTRA_MESSAGE = null;

    TextView weatherCityName;

    TextView weatherCityDay;
    TextView weatherCityNight;
    TextView weatherCityTmp;
    TextView weatherCityWind;

    ImageView weatherCityDayCode;
    ImageView weatherCityNightCode;

    String messagereal;


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

        weatherCityDay = (TextView) findViewById(R.id.weatherCityDay);
        weatherCityNight = (TextView) findViewById(R.id.weatherCityNight);
        weatherCityTmp = (TextView) findViewById(R.id.weatherCityTmp);
        weatherCityWind = (TextView) findViewById(R.id.weatherCityWind);

        weatherCityDayCode = (ImageView) findViewById(R.id.weatherCityDayCode);
        weatherCityNightCode = (ImageView) findViewById(R.id.weatherCityNightCode);

        try {
            messagereal = PinyinHelper.convertToPinyinString(message, "", PinyinFormat.WITHOUT_TONE);
        } catch (PinyinException e) {
            e.printStackTrace();
        }
        new HttpThreadDaily(messagereal,weatherCityDay,weatherCityNight,weatherCityTmp,weatherCityWind,weatherCityDayCode,weatherCityNightCode,handler).start();

        }

}
