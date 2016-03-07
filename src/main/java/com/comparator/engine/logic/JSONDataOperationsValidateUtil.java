package com.comparator.engine.logic;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Retman on 2016-03-04.
 */
public class JSONDataOperationsValidateUtil {

    public static boolean isCorrect(String jsonAsString) {
        try {
            new JSONObject(jsonAsString);
            return true;
        } catch (JSONException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
