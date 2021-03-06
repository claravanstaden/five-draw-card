package com.claravanstaden.impl;

import com.claravanstaden.*;

import java.util.*;


public class FiveCardPokerHandAnalyzer implements PokerHandStrategy {

    private final Deck deck;
    private final Hand hand;

    public FiveCardPokerHandAnalyzer(Deck deck, Hand hand) {
        this.deck = deck;
        this.hand = hand;
    }

    /**
     * Copied from https://www.rosettacode.org/wiki/Poker_hand_analyser#Java,
     * modified to use HandImpl object.
     */
    @Override
    public Score analyzeHand() {

        if (hand.getHandCount() != 5) {
            throw new RuntimeException("invalid hand size: expected 5, got " + hand.getHandCount());
        }

        if (hand.getCards().size() == 0) {
            throw new RuntimeException("invalid hand: no cards found");
        }

        Map<String, Integer> faceCount = new HashMap<>();
        long straight = 0, flush = 0;
        for (Card card : hand.getCards()) {

            int face = deck.getFaces().indexOf(card.getFace());
            if (face == -1) {
                throw new RuntimeException("invalid hand: non-existing face");
            }
            straight |= (1 << face);

            faceCount.merge(card.getFace(), 1, Integer::sum);

            if (deck.getSuites().indexOf(card.getSuite()) == -1) {
                throw new RuntimeException("invalid hand: non-existing suit");
            }
            flush |= (1 << card.getSuite().charAt(0));
        }

        // shift the bit pattern to the right as far as possible
        while (straight % 2 == 0)
            straight >>= 1;

        // straight is 00011111; A-2-3-4-5 is 1111000000001
        boolean hasStraight = straight == 0b11111 || straight == 0b1111000000001;

        // unsets right-most 1-bit, which may be the only one set
        boolean hasFlush = (flush & (flush - 1)) == 0;

        if (hasStraight && hasFlush)
            return new ScoreImpl("straight-flush");

        int total = 0;
        for (Map.Entry<String, Integer> entry : faceCount.entrySet()) {
            int count = entry.getValue();
            if (count == 4) {
                return new ScoreImpl("four-of-a-kind");
            }

            if (count == 3) {
                total += 3;
            } else if (count == 2) {
                total += 2;
            }
        }

        if (total == 5) {
            return new ScoreImpl("full-house");
        }

        if (hasFlush) {
            return new ScoreImpl("flush");
        }

        if (hasStraight) {
            return new ScoreImpl("straight");
        }

        if (total == 3) {
            return new ScoreImpl("three-of-a-kind");
        }

        if (total == 4) {
            return new ScoreImpl("two-pair");
        }

        if (total == 2) {
            return new ScoreImpl("one-pair");
        }
        return new ScoreImpl("high-card");
    }
}