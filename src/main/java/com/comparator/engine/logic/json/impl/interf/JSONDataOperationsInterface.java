package com.comparator.engine.logic.json.impl.interf;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Retman on 2016-03-02.
 */
public interface JSONDataOperationsInterface {
    <T extends Object> T getRightJSON(List<String> pathToFindJSON, String json, int index);

    <T> void addToJSON(String inputJsonToEdit, String[] pathToJSON, T objectToAdd);

    <T> void deleteFromJSON(String inputJsonToEdit, String[] pathToJSON, T objectToDelete);

    <T> void editJSON(String inputJsonToEdit, String[] pathToJSON, T valueToUpdate);

    JSONObject generateJSONObject(String json);
}
