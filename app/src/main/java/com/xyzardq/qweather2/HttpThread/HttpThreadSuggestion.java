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


    public HttpThreadSuggestion(String httpArg, TextView textView, Handler handler){
        this.httpArg = httpArg;
        this.textView = textView;
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
                        textView.setText(JsonAS.car_washing_brief + JsonAS.dressing_brief + JsonAS.flu_brief + JsonAS.sport_brief + JsonAS.travel_brief + JsonAS.uv_brief);

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
