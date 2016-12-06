package de.novatec.cg.sc.hanabi.common;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Deck {

    @SerializedName("cards")
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }
}
