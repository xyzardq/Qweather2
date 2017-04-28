package com.xyzardq.qweather2.HttpThread;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;


import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD1;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD2;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily.JsonAnalysisDailyD3;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisLocation;
import com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisSuggestion;
import com.xyzardq.qweather2.R;

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

    ImageView weatherCityDayCode;
    ImageView weatherCityNightCode;

    public String result;


    public HttpThreadDaily(String httpArg, TextView weatherCityDay,TextView weatherCityNight,TextView weatherCityTmp,TextView weatherCityWind,ImageView weatherCityDayCode,ImageView weatherCityNightCode, Handler handler){
        this.httpArg = httpArg;
        this.weatherCityDay = weatherCityDay;
        this.weatherCityNight = weatherCityNight;
        this.weatherCityTmp = weatherCityTmp;
        this.weatherCityWind = weatherCityWind;

        this.weatherCityDayCode = weatherCityDayCode;
        this.weatherCityNightCode = weatherCityNightCode;
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

                        weatherCityDay.setText("白天" + JsonAD1.text_day);
                        weatherCityNight.setText("夜间" + JsonAD1.text_night);
                        weatherCityTmp.setText(JsonAD1.low + "°/" + JsonAD1.high + "°");
                        weatherCityWind.setText(JsonAD1.wind_direction + "风" + JsonAD1.wind_scale + "级");
                        if (JsonAD1.code_day.equals("0")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_0);
                        } else if (JsonAD1.code_day.equals("1")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_1);
                        } else if (JsonAD1.code_day.equals("1")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_1);
                        } else if (JsonAD1.code_day.equals("2")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_2);
                        } else if (JsonAD1.code_day.equals("3")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_3);
                        } else if (JsonAD1.code_day.equals("4")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_4);
                        } else if (JsonAD1.code_day.equals("5")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_5);
                        } else if (JsonAD1.code_day.equals("6")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_6);
                        } else if (JsonAD1.code_day.equals("7")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_7);
                        } else if (JsonAD1.code_day.equals("8")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_8);
                        } else if (JsonAD1.code_day.equals("9")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_9);
                        } else if (JsonAD1.code_day.equals("10")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_10);
                        } else if (JsonAD1.code_day.equals("11")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_11);
                        } else if (JsonAD1.code_day.equals("12")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_12);
                        } else if (JsonAD1.code_day.equals("13")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_13);
                        } else if (JsonAD1.code_day.equals("14")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_14);
                        } else if (JsonAD1.code_day.equals("15")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_15);
                        } else if (JsonAD1.code_day.equals("16")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_16);
                        } else if (JsonAD1.code_day.equals("17")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_17);
                        } else if (JsonAD1.code_day.equals("18")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_18);
                        } else if (JsonAD1.code_day.equals("19")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_19);
                        } else if (JsonAD1.code_day.equals("20")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_20);
                        } else if (JsonAD1.code_day.equals("21")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_21);
                        } else if (JsonAD1.code_day.equals("22")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_22);
                        } else if (JsonAD1.code_day.equals("23")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_23);
                        } else if (JsonAD1.code_day.equals("24")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_24);
                        } else if (JsonAD1.code_day.equals("25")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_25);
                        } else if (JsonAD1.code_day.equals("26")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_26);
                        } else if (JsonAD1.code_day.equals("27")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_27);
                        } else if (JsonAD1.code_day.equals("28")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_28);
                        } else if (JsonAD1.code_day.equals("29")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_29);
                        } else if (JsonAD1.code_day.equals("30")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_30);
                        } else if (JsonAD1.code_day.equals("31")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_31);
                        } else if (JsonAD1.code_day.equals("32")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_32);
                        } else if (JsonAD1.code_day.equals("33")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_33);
                        } else if (JsonAD1.code_day.equals("34")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_34);
                        } else if (JsonAD1.code_day.equals("35")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_35);
                        } else if (JsonAD1.code_day.equals("36")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_36);
                        } else if (JsonAD1.code_day.equals("37")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_37);
                        } else if (JsonAD1.code_day.equals("38")) {
                            weatherCityDayCode.setImageResource(R.drawable.weathercode_38);
                        }

                        if (JsonAD1.code_day.equals("0")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_0);
                        } else if (JsonAD1.code_night.equals("1")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_1);
                        } else if (JsonAD1.code_night.equals("2")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_2);
                        } else if (JsonAD1.code_night.equals("3")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_3);
                        } else if (JsonAD1.code_night.equals("4")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_4);
                        } else if (JsonAD1.code_night.equals("5")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_5);
                        } else if (JsonAD1.code_night.equals("6")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_6);
                        } else if (JsonAD1.code_night.equals("7")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_7);
                        } else if (JsonAD1.code_night.equals("8")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_8);
                        } else if (JsonAD1.code_night.equals("9")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_9);
                        } else if (JsonAD1.code_night.equals("10")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_10);
                        } else if (JsonAD1.code_night.equals("11")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_11);
                        } else if (JsonAD1.code_night.equals("12")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_12);
                        } else if (JsonAD1.code_night.equals("13")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_13);
                        } else if (JsonAD1.code_night.equals("14")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_14);
                        } else if (JsonAD1.code_night.equals("15")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_15);
                        } else if (JsonAD1.code_night.equals("16")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_16);
                        } else if (JsonAD1.code_night.equals("17")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_17);
                        } else if (JsonAD1.code_night.equals("18")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_18);
                        } else if (JsonAD1.code_night.equals("19")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_19);
                        } else if (JsonAD1.code_night.equals("20")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_20);
                        } else if (JsonAD1.code_night.equals("21")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_21);
                        } else if (JsonAD1.code_night.equals("22")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_22);
                        } else if (JsonAD1.code_night.equals("23")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_23);
                        } else if (JsonAD1.code_night.equals("24")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_24);
                        } else if (JsonAD1.code_night.equals("25")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_25);
                        } else if (JsonAD1.code_night.equals("26")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_26);
                        } else if (JsonAD1.code_night.equals("27")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_27);
                        } else if (JsonAD1.code_night.equals("28")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_28);
                        } else if (JsonAD1.code_night.equals("29")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_29);
                        } else if (JsonAD1.code_night.equals("30")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_30);
                        } else if (JsonAD1.code_night.equals("31")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_31);
                        } else if (JsonAD1.code_night.equals("32")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_32);
                        } else if (JsonAD1.code_night.equals("33")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_33);
                        } else if (JsonAD1.code_night.equals("34")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_34);
                        } else if (JsonAD1.code_night.equals("35")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_35);
                        } else if (JsonAD1.code_night.equals("36")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_36);
                        } else if (JsonAD1.code_night.equals("37")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_37);
                        } else if (JsonAD1.code_night.equals("38")) {
                            weatherCityNightCode.setImageResource(R.drawable.weathercode_38);
                        }




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
