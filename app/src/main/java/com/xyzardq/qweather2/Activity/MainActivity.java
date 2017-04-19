package com.xyzardq.qweather2.Activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.xyzardq.qweather2.HttpThread.HttpThreadDaily;
import com.xyzardq.qweather2.R;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.test);
        new HttpThreadDaily("nanning",textView,handler).start();



    }
}
