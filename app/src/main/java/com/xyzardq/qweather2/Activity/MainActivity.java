package com.xyzardq.qweather2.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xyzardq.qweather2.HttpThread.HttpThreadDaily;
import com.xyzardq.qweather2.HttpThread.HttpThreadSuggestion;
import com.xyzardq.qweather2.R;

public class MainActivity extends AppCompatActivity {

    private EditText cityName;

    private Handler handler = new Handler();

    public final static String EXTRA_MESSAGE = null;

    public void Search(View view) {
        Intent intent = new Intent(this, WeatherCity.class);
        cityName = (EditText) findViewById(R.id.cityName);
        String message = cityName.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new HttpThreadDaily("nanning",textView,handler).start();
//        new HttpThreadSuggestion("nanning",textView,handler).start();



    }
}
