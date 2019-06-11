package com.claravanstaden;

import java.util.List;

public interface Hand {
    void add(Card card);

    Integer getHandCount();

    List<Card> getCards();
}
