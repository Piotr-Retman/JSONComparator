package com.comparator.engine.enumerator;

/**
 * Created by Retman on 2016-03-14.
 */
public enum State {

    EXPECTED("EXPECTED"), UNEXPECTED("UNEXPECTED");
    private final String text;

    /**
     * @param text
     */
    State(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
