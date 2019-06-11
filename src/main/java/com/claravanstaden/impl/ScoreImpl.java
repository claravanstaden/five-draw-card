package com.claravanstaden.impl;

import com.claravanstaden.Score;

public class ScoreImpl implements Score {
    private final String name;

    public ScoreImpl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}