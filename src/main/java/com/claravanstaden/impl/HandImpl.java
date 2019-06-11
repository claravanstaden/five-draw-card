package com.claravanstaden.impl;

import com.claravanstaden.Card;
import com.claravanstaden.Hand;

import java.util.ArrayList;
import java.util.List;

public class HandImpl implements Hand {

    private Integer handCount;

    private List<Card> cards = new ArrayList<>();

    public HandImpl(Integer handCount) {
        this.handCount = handCount;
    }

    public HandImpl(Integer handCount, List<Card> cards) {
        this.handCount = handCount;
        this.cards = cards;
    }

    @Override
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

    @Override
    public Integer getHandCount() {
        return handCount;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }
}
