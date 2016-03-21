package com.comparator.engine.logic.json.impl;

import com.comparator.engine.logic.json.impl.interf.JSONDataOperationsInterface;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Retman on 2016-03-04.
 */
public class JSONDataOperationsImpl implements JSONDataOperationsInterface {
    Logger logger = Logger.getGlobal();

    @SuppressWarnings(value = "unchecked")
    public <T extends Object> T getRightJSON(List<String> pathToFindJSON, String json, int index) {
        try {
            return (index < pathToFindJSON.size()) ? afterValid(json, pathToFindJSON, index) : (T) json;
        } catch (Exception ex) {
            logger.log(Level.ALL, ex.getMessage());
        }
        return null;
    }

    private <T extends Object> T afterValid(String json, List<String> pathToFindJSON, int index) {
        String objectToRetrieve = "";
        if (JSONDataOperationsValidateUtil.isCorrectJSON(json)) {
            String nameOfJSON = pathToFindJSON.get(index);
            Object outWhatDataTypeIsCurrentJSON = findOutWhatDataTypeIsCurrentJSON(json);
            objectToRetrieve = retrieveTheData(outWhatDataTypeIsCurrentJSON, nameOfJSON, json);
            index++;
        }
        return getRightJSON(pathToFindJSON, objectToRetrieve, index);
    }

    private String retrieveTheData(Object outWhatDataTypeIsCurrentJSON, String nameOfJSON, String json) {
        String objectToRetrieve = "";
        if (outWhatDataTypeIsCurrentJSON instanceof JSONArray) {
            String[] nameOfArrayAndIndexWhichElementItIs = nameOfJSON.replace("[", ":").replace("]", "").split(":");
            JSONArray object = new JSONArray(json);
            objectToRetrieve = object.get(Integer.valueOf(nameOfArrayAndIndexWhichElementItIs[1])).toString();
        } else if (outWhatDataTypeIsCurrentJSON instanceof JSONObject) {
            nameOfJSON = nameOfJSON.replace("[]", "");
            JSONObject object = new JSONObject(json);
            objectToRetrieve = object.get(nameOfJSON).toString();
        }
        return objectToRetrieve;
    }

    @SuppressWarnings(value = "unchecked")
    public <T extends Object> T findOutWhatDataTypeIsCurrentJSON(String json) {
        boolean jsonArray = JSONDataOperationsValidateUtil.isJSONArray(json);
        boolean jsonObject = JSONDataOperationsValidateUtil.isJSONObject(json);
        if (jsonArray) {
            return (T) new JSONArray();
        } else if (jsonObject) {
            return (T) new JSONObject();
        }
        return (T) new Object();
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
