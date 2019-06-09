package com.claravanstaden;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void testHandToString() {
        Deck deck = new Deck();
        Hand hand = new Hand(5);

        Hand fiveHand = deck.drawHand(hand);

        assertNotNull(fiveHand);
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck();
        String sorted = deck.toString();

        deck.shuffle();

        String shuffled = deck.toString();

        assertNotEquals(sorted, shuffled);
    }
}