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

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public void print() {
        System.out.print(this.toString());
    }

    public String toString() {
        return this.getFace() + this.getSuite();
    }
}