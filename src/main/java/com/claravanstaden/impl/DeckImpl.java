package com.claravanstaden.impl;

import com.claravanstaden.Card;
import com.claravanstaden.Deck;
import com.claravanstaden.Hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Standard 52 card deck, without wildcards.
 */
public class DeckImpl implements Deck {

    private Stack<Card> cards = new Stack<>();

    private List<String> suites = new ArrayList<>();

    private List<String> faces = new ArrayList<>();

    public DeckImpl() {
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

    /**
     * Using the Collections shuffle method for maintainability.
     */
    @Override
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
     * Draw cards based on the Hand size.
     * @param hand - Hand object, containing hand size.
     * @return hand
     */
    @Override
    public Hand drawHand(Hand hand) {
        for (int i = 0; i < hand.getHandCount(); i++) {
            hand.add(cards.pop());
        }

        return hand;
    }

    @Override
    public List<String> getSuites() {
        return suites;
    }

    @Override
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
