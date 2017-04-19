package com.xyzardq.qweather2.JsonAnalysis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2017/4/19.
 */

public class JsonAnalysisLocation {

    private final String od;

    public String id;
    public String name;
    public String country;
    public String path;
    public String timezone;
    public String timezone_offset;

    public JsonAnalysisLocation(String od) throws JSONException {
        this.od = od;
        JSONObject jsonObj = new JSONObject(od.toString());
        final String resultsArray = jsonObj.optString("results");

        JSONArray jsonArrayresults = new JSONArray(resultsArray);
        String results = jsonArrayresults.optString(0);

        JSONObject jsonObjresults = new JSONObject(results);
        final String location = jsonObjresults.optString("location");

        JSONObject jsonObjlocation = new JSONObject(location);
        final String id = jsonObjlocation.optString("id");
        final String name = jsonObjlocation.optString("name");
        final String country = jsonObjlocation.optString("country");
        final String path = jsonObjlocation.optString("path");
        final String timezone = jsonObjlocation.optString("timezone");
        final String timezone_offset = jsonObjlocation.optString("timezone_offset");

        this.id = id;
        this.name = name;
        this.country = country;
        this.path = path;
        this.timezone = timezone;
        this.timezone_offset = timezone_offset;

    }
}
