package com.claravanstaden;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

    private Stack<Card> cards = new Stack<>();

    private List<String> suites = new ArrayList<>();

    private List<String> faces = new ArrayList<>();

    public Deck() {
        suites.add("♥");
        suites.add("♦");
        suites.add("♣");
        suites.add("♠");

        faces.add("2");
        faces.add("3");
        faces.add("4");
        faces.add("5");
        faces.add("6");
        faces.add("7");
        faces.add("8");
        faces.add("9");
        faces.add("10");
        faces.add("J");
        faces.add("Q");
        faces.add("K");
        faces.add("A");

        for (String suite : faces) {
            for (String face : this.suites) {
                cards.add(new Card(face, suite));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Hand drawHand(Hand hand) {
        for (int i = 0; i < hand.getHandCount(); i++) {
            hand.add(cards.pop());
        }

        return hand;
    }

    public List<String> getSuites() {
        return suites;
    }

    public List<String> getFaces() {
        return faces;
    }

    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for (Card card : cards) {
            cardString.append(card.toString());
            cardString.append(" ");
        }

        return cardString.toString();
    }
}
