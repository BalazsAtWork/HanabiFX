package de.novatec.cg.sc.hanabi.common;

import java.util.List;

public class Player {
    private String name;
    private List<CardInHand> cards;

    public String getName() {
        return name;
    }

    public List<CardInHand> getCards() {
        return cards;
    }
}
