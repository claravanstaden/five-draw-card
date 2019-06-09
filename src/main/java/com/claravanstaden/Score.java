package com.claravanstaden;

import java.util.Arrays;

public class Score {
    final int weight;
    private final String name;

    Score(String name, int weight) {
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}