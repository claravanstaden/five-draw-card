package com.claravanstaden;

public class Card {

    private String suite;
    private String face;

    public Card(String suite, String face) {
        this.suite = suite;
        this.face = face;
    }

    public String getSuite() {
        return suite;
    }

    public String getFace() {
        return face;
    }

    public String toString() {
        return this.getFace() + this.getSuite();
    }
}