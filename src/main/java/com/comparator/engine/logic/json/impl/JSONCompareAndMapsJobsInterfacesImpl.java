package com.comparator.engine.logic.json.impl;

import com.comparator.engine.enumerator.ChangeType;
import com.comparator.engine.enumerator.ErrorConst;
import com.comparator.engine.enumerator.State;
import com.comparator.engine.exception.ValidateException;
import com.comparator.engine.logic.json.impl.interf.JSONCompareInterface;
import com.comparator.engine.logic.json.impl.interf.JSONMapsJobsInterface;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.util.*;

/**
 * Created by Retman on 2016-03-07.
 */
@SuppressWarnings("unchecked")
public class JSONCompareAndMapsJobsInterfacesImpl implements JSONCompareInterface, JSONMapsJobsInterface {
    @Override
    public <T> T compareJSONS(String compareFrom, String compareTo) throws ValidateException {
        T message = null;
        if (validateJSONS(compareFrom, compareTo)) {
            try {
                JSONAssert.assertEquals(compareTo, compareFrom, JSONCompareMode.STRICT_ORDER);
                message = (T) Boolean.TRUE;
            } catch (AssertionError ex) {
                message = (T) ex.getMessage();
            }
        } else {
            throw new ValidateException(ErrorConst.VALIDATE_ERROR_MESSAGE.toString());
        }
        return message;
    }

    @Override
    public Map<ChangeType, List<String>> generateMapJSONChangesTypesOnPathsAndValues(String compareFrom, String compareTo) throws ValidateException {
        Map<ChangeType, List<String>> mapTypeOnPaths = new HashMap<>();
        Object o = compareJSONS(compareFrom, compareTo);
        if (validateJSONS(compareFrom, compareTo)) {
            checkIfNotBooleanAndFillMapAndReplaceUnwantedChars(o, mapTypeOnPaths);
        }
        return mapTypeOnPaths;
    }

    private void checkIfNotBooleanAndFillMapAndReplaceUnwantedChars(Object o, Map<ChangeType, List<String>> mapTypeOnPaths) {
        if (!isBoolean(o)) {
            fillMap(mapTypeOnPaths, o);
            replaceAllNotWantedChars(mapTypeOnPaths);
        }
    }

    @Override
    public Map<String, List<String>> generateMapPathOnValues(List<String> listOfPathsOnValues) {
        Map<String, List<String>> mapPathOnValues = new HashMap<>();
        listOfPathsOnValues.stream().forEach(listElemPathOnVal -> {
            String[] splitPathAndValueString = listElemPathOnVal.split(":");
            List<String> list = Arrays.asList(splitPathAndValueString);
            removeUnnecessaryWhiteSpaces(list);
            String path = list.get(0);
            List<String> listVars = list.subList(1, list.size());
            mapPathOnValues.put(path, listVars);
        });
        return mapPathOnValues;
    }

    private void removeUnnecessaryWhiteSpaces(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.set(i, list.get(i).trim().replaceAll(" +", " "));
        }
    }

    private Map<ChangeType, List<String>> replaceAllNotWantedChars(Map<ChangeType, List<String>> mapTypeOnPaths) {
        Set<ChangeType> changeTypes = mapTypeOnPaths.keySet();

        Iterator<ChangeType> iterator = changeTypes.iterator();
        while (iterator.hasNext()) {
            ChangeType changeType = iterator.next();
            List<String> list = mapTypeOnPaths.get(changeType);
            switch (changeType) {
                case EXPECTED:
                    list.replaceAll(s -> s.replace("Expected", "").replace("got", ""));
                    break;
                case UNEXPECTED:
                    list.replaceAll(s -> s.replace("Unexpected", "").replace("got", ""));
                    break;
            }
            mapTypeOnPaths.replace(changeType, list);
        }
        return mapTypeOnPaths;
    }

    private void fillMap(Map<ChangeType, List<String>> mapTypeOnPaths, Object diffString) {
        List<String> listDiffs = Arrays.asList(prepareStringArrayBasedOnDiffStr(diffString));

        List<String> expected = createExpectedList(State.EXPECTED, listDiffs);
        mapTypeOnPaths.put(ChangeType.EXPECTED, expected);

        List<String> unexpected = createUnexpectedList(State.UNEXPECTED, listDiffs);
        mapTypeOnPaths.put(ChangeType.UNEXPECTED, unexpected);

    }

    private String[] prepareStringArrayBasedOnDiffStr(Object diffString) {
        return diffString.toString().replace("\n", "").split(";");
    }

    private List<String> createUnexpectedList(State state, List<String> listDiffs) {
        return generateDataBasedOnCurrentDifferenceState(state, listDiffs);
    }

    private List<String> createExpectedList(State state, List<String> listDiffs) {
        return generateDataBasedOnCurrentDifferenceState(state, listDiffs);
    }

    private List<String> generateDataBasedOnCurrentDifferenceState(State state, List<String> listDiffs) {
        List<String> listOfExpected = new ArrayList<>();
        listDiffs.stream().filter(s -> s.toUpperCase().contains(state.name()))
                .allMatch(listOfExpected::add);
        return listOfExpected;
    }

    private boolean isBoolean(Object object) {
        return object instanceof Boolean;
    }

    private boolean validateJSONS(String compareFrom, String compareTo) {
        return JSONDataOperationsValidateUtil.isCorrectJSON(compareFrom) && JSONDataOperationsValidateUtil.isCorrectJSON(compareTo);
    }
}
