package com.comparator.engine.logic.json.impl.interf;


import com.comparator.engine.exception.ValidateException;

/**
 * Created by Retman on 2016-03-04.
 */
public interface JSONCompareInterface {
    <T extends Object> T compareJSONS(String compareFrom, String compareTo) throws ValidateException;
}
