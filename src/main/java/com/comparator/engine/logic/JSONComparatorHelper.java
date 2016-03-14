package com.comparator.engine.logic;

import java.util.List;

/**
 * Created by Retman on 2016-03-14.
 */
public class JSONComparatorHelper {
    public static List<String> fillList(List<String> dataToUpdate,String dataToAdd){
        dataToUpdate.add(dataToAdd);
        return dataToUpdate;
    }


}
