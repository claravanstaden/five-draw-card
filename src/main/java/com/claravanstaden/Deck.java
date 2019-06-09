package com.claravanstaden;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

    private Stack<Card> cards = new Stack<Card>();

    public Deck() {
        List<String> faces = new ArrayList<>();
        faces.add("♥");
        faces.add("♦");
        faces.add("♣");
        faces.add("♠");

        List<String> suites = new ArrayList<>();
        suites.add("2");
        suites.add("3");
        suites.add("4");
        suites.add("5");
        suites.add("6");
        suites.add("7");
        suites.add("8");
        suites.add("9");
        suites.add("J");
        suites.add("Q");
        suites.add("K");
        suites.add("A");

        for (String suite : suites) {
            for (String face : faces) {
                cards.add(new Card(face, suite));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public void print() {
        for (Card card : this.cards) {
            card.print();
            System.out.print(" ");
        }
        System.out.println();
    }

    public Hand drawHand(Hand hand) {
        for (int i = 0; i < hand.getHandCount(); i++) {
            hand.add(cards.pop());
        }

        return hand;
    }
}
