package com.xyzardq.qweather2.HttpThread;

import android.os.Handler;
import android.widget.TextView;


import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD1;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD2;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD3;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisLocation;

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

    private TextView textView;
    public String result;


    public HttpThreadDaily(String httpArg, TextView textView, Handler handler){
        this.httpArg = httpArg;
        this.textView = textView;
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
                final JsonAnalysisLocation JsonAL = new JsonAnalysisLocation(od.toString());
                final JsonAnalysisDailyD1 JsonAD1 = new JsonAnalysisDailyD1(od.toString());
                final JsonAnalysisDailyD2 JsonAD2 = new JsonAnalysisDailyD2(od.toString());
                final JsonAnalysisDailyD3 JsonAD3 = new JsonAnalysisDailyD3(od.toString());


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(JsonAD3.date);

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
