package com.claravanstaden;

import java.util.*;


public class PokerHandAnalyzer {

    private final Deck deck;
    private final Hand hand;

    public PokerHandAnalyzer(Deck deck, Hand hand) {
        this.deck = deck;
        this.hand = hand;
    }

    /**
     * Copied from https://www.rosettacode.org/wiki/Poker_hand_analyser#Java,
     * modified to use Hand object.
     */
    public Score analyzeHand() {

        if (hand.getCards().size() == 0) {
            return new Score("invalid hand: no cards found", -1);
        }
        Map<String, Integer> faceCount = new HashMap<>();
        long straight = 0, flush = 0;
        for (Card card : hand.getCards()) {

            int face = deck.getFaces().indexOf(card.getFace());
            if (face == -1) {
                return new Score("invalid hand: non-existing face", -1);
            }
            straight |= (1 << face);

            faceCount.merge(card.getFace(), 1, Integer::sum);

            if (deck.getSuites().indexOf(card.getSuite()) == -1) {
                return new Score("invalid hand: non-existing suit", -1);
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
            return new Score("straight-flush", 9);

        int total = 0;
        for (Map.Entry<String, Integer> entry : faceCount.entrySet()) {
            int count = entry.getValue();
            if (count == 4) {
                return new Score("four-of-a-kind", 8);
            }

            if (count == 3) {
                total += 3;
            } else if (count == 2) {
                total += 2;
            }
        }

        if (total == 5) {
            return new Score("full-house", 7);
        }

        if (hasFlush) {
            return new Score("flush", 6);
        }

        if (hasStraight) {
            return new Score("straight", 5);
        }

        if (total == 3) {
            return new Score("three-of-a-kind", 4);
        }

        if (total == 4) {
            return new Score("two-pair", 3);
        }

        if (total == 2) {
            return new Score("one-pair", 2);
        }
        return new Score("high-card", 1);
    }
}