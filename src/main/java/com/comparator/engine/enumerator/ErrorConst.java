package com.comparator.engine.enumerator;

/**
 * Created by Retman on 2016-03-16.
 */
public enum ErrorConst {
    VALIDATE_ERROR_MESSAGE("There are some problems with JSONs! If it is JSONArray is should start with '[' if it is JSONObject it should start with '{'");

    private final String text;

    /**
     * @param text
     */
    ErrorConst(final String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return text;
    }
}
