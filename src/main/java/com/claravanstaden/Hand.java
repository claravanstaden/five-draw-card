package com.claravanstaden;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private Integer handCount;

    private List<Card> cards = new ArrayList<>();

    public Hand(Integer handCount) {
        this.handCount = handCount;
    }

    public Hand(Integer handCount, List<Card> cards) {
        this.handCount = handCount;
        this.cards = cards;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public String toString() {
        StringBuilder cardString = new StringBuilder();
        for (Card card : this.cards) {
            cardString.append(card.toString());
            cardString.append(" ");
        }
        return cardString.toString();
    }

    public Integer getHandCount() {
        return handCount;
    }

    public List<Card> getCards() {
        return cards;
    }
}
