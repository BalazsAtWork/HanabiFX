package de.novatec.cg.sc.hanabi.common;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;

public class GameState {

    private int hintTokens;
    private int errorTokens;

    private List<Player> player;

    @SerializedName("played_cards")
    private HashMap<Color, Number> playedCards;

    @Override
    public String toString() {
        return "GameState";
    }
}
