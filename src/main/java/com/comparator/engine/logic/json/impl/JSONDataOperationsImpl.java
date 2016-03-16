package com.comparator.engine.logic.json.impl;

import com.comparator.engine.logic.json.impl.interf.JSONDataOperationsInterface;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Retman on 2016-03-04.
 */
public class JSONDataOperationsImpl implements JSONDataOperationsInterface {

    public String getRightJSON(String[] pathToFindJSON, String json) {
        String finalJson = "";
        if (JSONDataOperationsValidateUtil.isCorrectJSON(json)) {
            Object outWhatDataTypeIsCurrentJSON = findOutWhatDataTypeIsCurrentJSON(json);

            for (int i = 0; i <= pathToFindJSON.length; i++) {
                if (outWhatDataTypeIsCurrentJSON instanceof JSONArray) {
                    JSONArray list = new JSONArray(json);
                } else if (outWhatDataTypeIsCurrentJSON instanceof JSONObject) {
                    JSONObject object = new JSONObject(json);
                }
            }
        }
        return finalJson;
    }

    @SuppressWarnings(value = "unchecked")
    private <T extends Object> T findOutWhatDataTypeIsCurrentJSON(String json) {
        boolean jsonArray = JSONDataOperationsValidateUtil.isJSONArray(json);
        boolean jsonObject = JSONDataOperationsValidateUtil.isJSONObject(json);
        if (jsonArray) {
            return (T) new JSONArray();
        } else if (jsonObject) {
            return (T) new JSONObject();
        }
        return null;
    }


    public <T> void addToJSON(String inputJsonToEdit, String[] pathToJSON, T objectToAdd) {

    }


    public <T> void deleteFromJSON(String inputJsonToEdit, String[] pathToJSON, T objectToDelete) {

    }


    public <T> void editJSON(String inputJsonToEdit, String[] pathToJSON, T valueToUpdate) {

    }

    public JSONObject generateJSONObject(String json) {
        JSONObject jsonObject = new JSONObject();
        if (JSONDataOperationsValidateUtil.isCorrectJSON(json)) {
            jsonObject = new JSONObject(json);
        }
        return jsonObject;
    }
}
