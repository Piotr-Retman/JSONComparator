package com.comparator.engine.logic.json.impl.interf;


import com.comparator.engine.enumerator.ChangeType;
import com.comparator.engine.exception.ValidateException;

import java.util.List;
import java.util.Map;

/**
 * Created by Retman on 2016-03-04.
 */
public interface JSONCompareInterface {
    <T extends Object> T compareJSONS(String compareFrom, String compareTo) throws ValidateException;
}
