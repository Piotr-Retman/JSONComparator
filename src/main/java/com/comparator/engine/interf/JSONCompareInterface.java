package com.comparator.engine.interf;


import java.util.List;
import java.util.Map;

/**
 * Created by Retman on 2016-03-04.
 */
public interface JSONCompareInterface {
    <T extends Object> T compareJSONS(String compareFrom, String compareTo);
    Map<ChangeType,List<String>> generateMapJSONChangesTypesOnPaths(String compareFrom, String compareTo);
}
