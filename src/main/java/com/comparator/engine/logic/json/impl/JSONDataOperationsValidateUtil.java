package com.comparator.engine.logic.json.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Retman on 2016-03-04.
 */
public class JSONDataOperationsValidateUtil {

    public static boolean isCorrectJSON(String jsonAsString) {
        boolean isItOk = false;
        if(isJSONObject(jsonAsString)){
            isItOk = true;
        }else if(isJSONArray(jsonAsString)){
            isItOk = true;
        }
        return isItOk;
    }

    public static boolean isJSONObject(String jsonAsString){
        try {
            new JSONObject(jsonAsString);
            return true;
        } catch (JSONException ex) {
            return false;
        }
    }

    public static boolean isJSONArray(String jsonAsString){
        try {
            new JSONArray(jsonAsString);
            return true;
        } catch (JSONException ex) {
            return false;
        }
    }


}
