package com.comparator.engine.logic.json.impl.interf;

import org.json.JSONObject;

/**
 * Created by Retman on 2016-03-02.
 */
public interface JSONDataOperationsInterface {
    String getRightJSON(String[] pathToFindJSON,String json);
    <T> void addToJSON(String inputJsonToEdit,String[] pathToJSON,T objectToAdd);
    <T> void deleteFromJSON(String inputJsonToEdit,String[] pathToJSON,T objectToDelete);
    <T> void editJSON(String inputJsonToEdit,String[] pathToJSON,T valueToUpdate);
    JSONObject generateJSONObject(String json);
}
