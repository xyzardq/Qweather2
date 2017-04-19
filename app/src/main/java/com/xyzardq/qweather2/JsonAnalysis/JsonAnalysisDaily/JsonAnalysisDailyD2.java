package com.xyzardq.qweather2.JsonAnalysis.JsonAnalysisDaily;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/4/19.
 */

public class JsonAnalysisDailyD2 {

    private final String od;

    public String date;
    public String text_day;
    public String code_day;
    public String text_night;
    public String code_night;
    public String high;
    public String low;
    public String wind_direction;
    public String wind_direction_degree;
    public String wind_speed;
    public String wind_scale;

    public JsonAnalysisDailyD2(String od) throws JSONException {
        this.od = od;
        JSONObject jsonObj = new JSONObject(od.toString());
        final String resultsArray = jsonObj.optString("results");

        JSONArray jsonArrayresults = new JSONArray(resultsArray);
        String results = jsonArrayresults.optString(0);

        JSONObject jsonObjresults = new JSONObject(results);
        final String daily = jsonObjresults.optString("daily");

        JSONArray jsonArraydaily = new JSONArray(daily);
        String dailyTd = jsonArraydaily.optString(1);

        JSONObject jsonObjdailyTd = new JSONObject(dailyTd);
        final String date = jsonObjdailyTd.optString("date");
        final String text_day = jsonObjdailyTd.optString("text_day");
        final String code_day = jsonObjdailyTd.optString("code_day");
        final String text_night = jsonObjdailyTd.optString("text_night");
        final String code_night = jsonObjdailyTd.optString("code_night");
        final String high = jsonObjdailyTd.optString("high");
        final String low = jsonObjdailyTd.optString("low");
        final String wind_direction = jsonObjdailyTd.optString("wind_direction");
        final String wind_direction_degree = jsonObjdailyTd.optString("wind_direction_degree");
        final String wind_speed = jsonObjdailyTd.optString("wind_speed");
        final String wind_scale = jsonObjdailyTd.optString("wind_scale");

        this.date = date;
        this.text_day = text_day;
        this.code_day = code_day;
        this.text_night = text_night;
        this.code_night = code_night;
        this.high = high;
        this.low = low;
        this.wind_direction = wind_direction;
        this.wind_direction_degree = wind_direction_degree;
        this.wind_speed = wind_speed;
        this.wind_scale = wind_scale;
    }
}
