import com.claravanstaden.Card;
import com.claravanstaden.Deck;
import com.claravanstaden.Hand;
import com.claravanstaden.PokerHandAnalyzer;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();

        deck.shuffle();

        System.out.println("Shuffling... Shuffling... Shuffling...");

        Hand hand = new Hand(5);
        deck.drawHand(hand);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);

        System.out.println("Your hand: " + hand.toString());
        System.out.println("Your have: " + pokerHandAnalyzer.analyzeHand());
    }
}
