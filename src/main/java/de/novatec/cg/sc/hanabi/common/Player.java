package de.novatec.cg.sc.hanabi.common;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("name")
    private String name;

    @SerializedName("cards")
    private List<CardInHand> cards;

    public String getName() {
        return name;
    }

    public List<CardInHand> getCards() {
        return cards;
    }
}
