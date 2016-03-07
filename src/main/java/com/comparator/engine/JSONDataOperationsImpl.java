package com.comparator.engine;

import com.comparator.engine.interf.JSONDataOperationsInterface;
import org.json.JSONObject;

/**
 * Created by Retman on 2016-03-04.
 */
public class JSONDataOperationsImpl implements JSONDataOperationsInterface {

    public String getRightJSON(String[] pathToFindJSON, String json) {
        return null;
    }


    public <T> void addToJSON(String jsonToEdit, String[] pathToJSON, T objectToAdd) {

    }


    public <T> void deleteFromJSON(String jsonToEdit, String[] pathToJSON, T objectToDelete) {

    }


    public String editJSON(String jsonToEdit, String[] pathToJSON, String valueToUpdate) {
        return null;
    }

    public JSONObject generateJSONObject(String json) {
        JSONObject jsonObject = new JSONObject();
        if (JSONDataOperationsValidateUtil.isCorrect(json)) {
            jsonObject = new JSONObject(json);
        }
        return jsonObject;
    }
}
