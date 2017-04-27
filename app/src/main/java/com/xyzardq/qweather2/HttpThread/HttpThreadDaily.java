package com.xyzardq.qweather2.HttpThread;

import android.os.Handler;
import android.widget.TextView;


import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD1;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD2;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD3;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisLocation;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisSuggestion;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/19.
 */
public class HttpThreadDaily extends Thread {

    private String httpUrl;
    private String httpArg;
    private Handler handler;

    private TextView weatherCityDay;
    private TextView weatherCityNight;
    private TextView weatherCityTmp;
    private TextView weatherCityWind;
    public String result;


    public HttpThreadDaily(String httpArg, TextView weatherCityDay, Handler handler){
        this.httpArg = httpArg;
        this.weatherCityDay = weatherCityDay;
        this.weatherCityNight = weatherCityNight;
        this.weatherCityTmp = weatherCityTmp;
        this.weatherCityWind = weatherCityWind;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            httpUrl = "http://api.seniverse.com/v3/weather/daily.json?key=w2ybdishymhay0y0&location=" + httpArg + "&language=zh-Hans&unit=c&start=0&days=5";
            URL url = new URL(httpUrl);
            try {
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setReadTimeout(5000);
                connect.setRequestMethod("GET");
                connect.connect();
                final StringBuffer od = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                String str;
                while((str = reader.readLine())!=null){
                    od.append(str);
                }
                result = od.toString();
                final JsonAnalysisDailyD1 JsonAD1 = new JsonAnalysisDailyD1(od.toString());


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        weatherCityDay.setText("123123");

//                        weatherCityDay.setText("白天" + JsonAD1.text_day);
//                        weatherCityNight.setText("夜间" + JsonAD1.text_night);
//                        weatherCityWind.setText(JsonAD1.wind_direction + JsonAD1.wind_direction_degree);

                    }


                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
