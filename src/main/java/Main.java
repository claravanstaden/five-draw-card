import com.claravanstaden.*;
import com.claravanstaden.impl.DeckImpl;
import com.claravanstaden.impl.HandImpl;
import com.claravanstaden.impl.FiveCardPokerHandAnalyzer;

public class Main {

    public static void main(String[] args) {

        // Output split from logic to separate presentation layer
        Deck deck = new DeckImpl();

        deck.shuffle();

        System.out.println("Shuffling... Shuffling... Shuffling...");

        Hand hand = new HandImpl(5);
        deck.drawHand(hand);

        PokerHandStrategy pokerHandStrategy = new FiveCardPokerHandAnalyzer(deck, hand);

        // Automatic toString invocation
        System.out.println("Your hand: " + hand.toString());
        System.out.println("Your have: " + pokerHandStrategy.analyzeHand());
    }
}
