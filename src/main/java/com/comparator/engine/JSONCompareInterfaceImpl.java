package com.comparator.engine;

import com.comparator.engine.interf.ChangeType;
import com.comparator.engine.interf.JSONCompareInterface;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Retman on 2016-03-07.
 */
@SuppressWarnings("unchecked")
public class JSONCompareInterfaceImpl implements JSONCompareInterface {
    @Override
    public <T> T compareJSONS(String compareFrom, String compareTo) {
        T message = null;
        if (validateJSONS(compareFrom, compareTo)) {
            try {
                JSONAssert.assertEquals(compareTo, compareFrom, JSONCompareMode.STRICT_ORDER);

                message = (T) Boolean.TRUE;
            } catch (AssertionError ex) {
                message = (T) ex.getMessage();
            }
        }
        return message;
    }

    @Override
    public Map<ChangeType, List<String>> generateMapJSONChangesTypesOnPaths(String compareFrom, String compareTo) {
        Map<ChangeType, List<String>> mapTypeOnPaths = new HashMap<>();
        if(validateJSONS(compareFrom,compareTo)){
            JSONAssert.assertEquals(compareFrom,compareTo,JSONCompareMode.STRICT_ORDER);

        }
        return null;
    }

    private boolean validateJSONS(String compareFrom, String compareTo) {
        return JSONDataOperationsValidateUtil.isCorrect(compareFrom) && JSONDataOperationsValidateUtil.isCorrect(compareTo);
    }
}
