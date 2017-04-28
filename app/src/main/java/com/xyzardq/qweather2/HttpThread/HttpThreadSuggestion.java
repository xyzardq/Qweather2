package com.xyzardq.qweather2.HttpThread;

import android.os.Handler;
import android.widget.TextView;


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
public class HttpThreadSuggestion extends Thread {

    private String httpUrl;
    private String httpArg;
    private Handler handler;

    private TextView textView;
    public String result;

    private TextView weatherDetailCar;
    private TextView weatherDetailDressing;
    private TextView weatherDetailFlu;
    private TextView weatherDetailSport;
    private TextView weatherDetailTravel;
    private TextView weatherDetailUv;


    public HttpThreadSuggestion(String httpArg, TextView weatherDetailCar, TextView weatherDetailDressing, TextView weatherDetailFlu, TextView weatherDetailSport, TextView weatherDetailTravel, TextView weatherDetailUv, Handler handler){
        this.httpArg = httpArg;
        this.weatherDetailCar = weatherDetailCar;
        this.weatherDetailDressing = weatherDetailDressing;
        this.weatherDetailFlu = weatherDetailFlu;
        this.weatherDetailSport = weatherDetailSport;
        this.weatherDetailTravel = weatherDetailTravel;
        this.weatherDetailUv = weatherDetailUv;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            httpUrl = "https://api.seniverse.com/v3/life/suggestion.json?key=w2ybdishymhay0y0&location=" + httpArg + "&language=zh-Hans";
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

                final JsonAnalysisSuggestion JsonAS= new JsonAnalysisSuggestion(od.toString());


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        weatherDetailCar.setText("洗车指数：" + JsonAS.car_washing_brief);
                        weatherDetailDressing.setText("穿衣指数：" + JsonAS.dressing_brief);
                        weatherDetailFlu.setText("感冒指数：" + JsonAS.flu_brief);
                        weatherDetailSport.setText("运动指数：" + JsonAS.sport_brief);
                        weatherDetailTravel.setText("旅游指数：" + JsonAS.travel_brief);
                        weatherDetailUv.setText("紫外线指数：" + JsonAS.uv_brief);

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
