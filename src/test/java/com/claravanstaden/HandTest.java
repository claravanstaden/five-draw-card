package com.claravanstaden;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HandTest {

    @Test
    public void testHandToString() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "J"));
        cards.add(new Card("♦", "4"));
        cards.add(new Card("♦", "10"));
        cards.add(new Card("♣", "9"));
        cards.add(new Card("♦", "2"));
        Hand hand = new Hand(5, cards);

        assertEquals("J♥ 4♦ 10♦ 9♣ 2♦ " , hand.toString());
    }
}