package com.xyzardq.qweather2.JsonAnalysis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/4/19.
 */

public class JsonAnalysisSuggestion {

    private final String od;

    public String car_washing_brief;
    public String dressing_brief;
    public String flu_brief;
    public String sport_brief;
    public String travel_brief;
    public String uv_brief;


    public JsonAnalysisSuggestion(String od) throws JSONException {
        this.od = od;
        JSONObject jsonObj = new JSONObject(od.toString());
        final String resultsArray = jsonObj.optString("results");

        JSONArray jsonArrayresults = new JSONArray(resultsArray);
        String results = jsonArrayresults.optString(0);

        JSONObject jsonObjresults = new JSONObject(results);
        final String suggestion = jsonObjresults.optString("suggestion");

        JSONObject jsonObjsuggestion = new JSONObject(suggestion);
        final String car_washing = jsonObjsuggestion.optString("car_washing");
        final String dressing = jsonObjsuggestion.optString("dressing");
        final String flu = jsonObjsuggestion.optString("flu");
        final String sport = jsonObjsuggestion.optString("sport");
        final String travel = jsonObjsuggestion.optString("travel");
        final String uv = jsonObjsuggestion.optString("uv");

        JSONObject jsonObjcar_washing = new JSONObject(car_washing);
        final String car_washing_brief = jsonObjcar_washing.optString("brief");
        this.car_washing_brief = car_washing_brief;

        JSONObject jsonObjdressing = new JSONObject(dressing);
        final String dressing_brief = jsonObjdressing.optString("brief");
        this.dressing_brief = dressing_brief;

        JSONObject jsonObjflu = new JSONObject(flu);
        final String flu_brief = jsonObjflu.optString("brief");
        this.flu_brief = flu_brief;

        JSONObject jsonObjsport = new JSONObject(sport);
        final String sport_brief = jsonObjsport.optString("brief");
        this.sport_brief = sport_brief;

        JSONObject jsonObjtravel = new JSONObject(travel);
        final String travel_brief = jsonObjtravel.optString("brief");
        this.travel_brief = travel_brief;

        JSONObject jsonObjuv = new JSONObject(uv);
        final String uv_brief = jsonObjuv.optString("brief");
        this.uv_brief = uv_brief;

    }
}
