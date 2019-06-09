package com.claravanstaden;

public class Score {
    private final String name;

    Score(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}