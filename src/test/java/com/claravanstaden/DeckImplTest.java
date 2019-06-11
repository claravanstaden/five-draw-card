package com.claravanstaden;

import com.claravanstaden.impl.DeckImpl;
import com.claravanstaden.impl.HandImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckImplTest {

    @Test
    public void testHandToString() {
        Deck deck = new DeckImpl();
        Hand hand = new HandImpl(5);

        Hand fiveHand = deck.drawHand(hand);

        assertNotNull(fiveHand);
    }

    @Test
    public void testShuffle() {
        Deck deck = new DeckImpl();
        String sorted = deck.toString();

        deck.shuffle();

        String shuffled = deck.toString();

        assertNotEquals(sorted, shuffled);
    }
}