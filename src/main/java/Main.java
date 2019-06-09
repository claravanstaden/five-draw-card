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
        deck.print();
        deck.printSize();

        System.out.println("Shuffling... Shuffling... Shuffling...");

        Hand hand = new Hand(5);
        deck.drawHand(hand);

        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer(deck, hand);

        System.out.println("Your hand: " + hand.toString());
        System.out.println("Your have: " + pokerHandAnalyzer.analyzeHand());

        /*
        PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzer();
        System.out.println("=============================:\n");
        System.out.println("Regular hands:\n");
        for (String input : new String[]{"2H 2D 2S KS QD",
                "2H 5H 7D 8S 9D",
                "AH 2D 3S 4S 5S",
                "2H 3H 2D 3S 3D",
                "2H 7H 2D 3S 3D",
                "2H 7H 7D 7S 7C",
                "TH JH QH KH AH",
                "4H 4C KC 5D TC",
                "QC TC 7C 6C 4C",
                "QC TC 7C 7C TD"}) {
            System.out.println(pokerHandAnalyzer.analyzeHand(input.split(" ")));
        }

        System.out.println("\nHands with wildcards:\n");
        for (String input : new String[]{"2H 2D 2S KS WW",
                "2H 5H 7D 8S WW",
                "AH 2D 3S 4S WW",
                "2H 3H 2D 3S WW",
                "2H 7H 2D 3S WW",
                "2H 7H 7D WW WW",
                "TH JH QH WW WW",
                "4H 4C KC WW WW",
                "QC TC 7C WW WW",
                "QC TC 7H WW WW"}) {
            System.out.println(pokerHandAnalyzer.analyzeHandWithWildcards(input.split(" ")));
        }*/
    }
}
