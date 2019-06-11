package com.claravanstaden;

import java.util.List;

public interface Deck {
    void shuffle();

    Hand drawHand(Hand hand);

    List<String> getSuites();

    List<String> getFaces();
}
