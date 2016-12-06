package de.novatec.cg.sc.hanabi.common;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("name")
    private String name;

    @SerializedName("cards")
    private List<CardInHand> cards;

    public Player(String name, List<CardInHand> cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public List<CardInHand> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", cards=" + cards + "]";
    }

}
