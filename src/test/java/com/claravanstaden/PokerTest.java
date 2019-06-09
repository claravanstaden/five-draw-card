package com.claravanstaden;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PokerTest {

    Deck deck;
    Hand hand;

    @Before
    public void setUp() {
        deck = new Deck();

    }

    @Test
    public void testStraightFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "10"));
        cards.add(new Card("♥", "J"));
        cards.add(new Card("♥", "Q"));
        cards.add(new Card("♥", "K"));
        cards.add(new Card("♥", "A"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("straight-flush", score.toString());
    }

    @Test
    public void testFourOfAKind() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "A"));
        cards.add(new Card("♥", "7"));
        cards.add(new Card("♠", "7"));
        cards.add(new Card("♣", "7"));
        cards.add(new Card("♦", "7"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("four-of-a-kind", score.toString());
    }

    @Test
    public void testFullHouse() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "A"));
        cards.add(new Card("♥", "A"));
        cards.add(new Card("♠", "7"));
        cards.add(new Card("♣", "7"));
        cards.add(new Card("♦", "7"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("full-house", score.toString());
    }

    @Test
    public void testFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♠", "A"));
        cards.add(new Card("♠", "5"));
        cards.add(new Card("♠", "7"));
        cards.add(new Card("♠", "9"));
        cards.add(new Card("♠", "2"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("flush", score.toString());
    }

    @Test
    public void testStraight() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "10"));
        cards.add(new Card("♥", "J"));
        cards.add(new Card("♠", "Q"));
        cards.add(new Card("♠", "K"));
        cards.add(new Card("♦", "A"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("straight", score.toString());
    }

    @Test
    public void testThreeOfAKind() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "8"));
        cards.add(new Card("♥", "8"));
        cards.add(new Card("♥", "8"));
        cards.add(new Card("♠", "K"));
        cards.add(new Card("♦", "A"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("three-of-a-kind", score.toString());
    }

    @Test
    public void testTwoPair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "J"));
        cards.add(new Card("♣", "J"));
        cards.add(new Card("♦", "9"));
        cards.add(new Card("♣", "9"));
        cards.add(new Card("♦", "2"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("two-pair", score.toString());
    }

    @Test
    public void testOnePair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "J"));
        cards.add(new Card("♣", "J"));
        cards.add(new Card("♦", "7"));
        cards.add(new Card("♣", "9"));
        cards.add(new Card("♦", "2"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("one-pair", score.toString());
    }

    @Test
    public void testHighCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "J"));
        cards.add(new Card("♣", "4"));
        cards.add(new Card("♦", "7"));
        cards.add(new Card("♣", "9"));
        cards.add(new Card("♦", "2"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("high-card", score.toString());
    }


    @Test
    public void testInvalidSuite() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "J"));
        cards.add(new Card("dd", "4"));
        cards.add(new Card("♦", "7"));
        cards.add(new Card("♣", "9"));
        cards.add(new Card("♦", "2"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("invalid hand: non-existing suit", score.toString());
    }

    @Test
    public void testInvalidFace() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("♥", "J"));
        cards.add(new Card("♦", "4"));
        cards.add(new Card("♦", "jd"));
        cards.add(new Card("♣", "9"));
        cards.add(new Card("♦", "2"));
        hand = new Hand(5, cards);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);
        Score score = pokerHandAnalyzer.analyzeHand();

        assertEquals("invalid hand: non-existing face", score.toString());
    }

    @Test
    public void testShuffle() {
        deck.shuffle();
    }
}