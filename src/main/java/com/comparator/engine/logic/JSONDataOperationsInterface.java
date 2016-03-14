package com.comparator.engine.logic;

import org.json.JSONObject;

/**
 * Created by Retman on 2016-03-02.
 */
public interface JSONDataOperationsInterface {
    String getRightJSON(String[] pathToFindJSON,String json);
    <T> void addToJSON(String jsonToEdit,String[] pathToJSON,T objectToAdd);
    <T> void deleteFromJSON(String jsonToEdit,String[] pathToJSON,T objectToDelete);
    String editJSON(String jsonToEdit,String[] pathToJSON,String valueToUpdate);
    JSONObject generateJSONObject(String json);
}
