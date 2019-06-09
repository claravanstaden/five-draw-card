package com.claravanstaden;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CardTest {

    @Test
    public void testCardToString() {
        Card card = new Card("♣", "10");

        assertEquals("10♣", card.toString());
    }
}