package com.comparator.engine.logic;

import com.comparator.engine.enumerator.ChangeType;

import java.util.List;
import java.util.Map;

/**
 * Created by Retman on 2016-03-15.
 */
public interface JSONMapsJobsInterface {
    Map<ChangeType,List<String>> generateMapJSONChangesTypesOnPathsAndValues(String compareFrom, String compareTo);
    Map<String,List<String>> generateMapPathOnValues(List<String> listAsStringsPathOnValue);
}
