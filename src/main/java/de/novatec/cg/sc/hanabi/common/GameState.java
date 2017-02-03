package de.novatec.cg.sc.hanabi.common;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.Number;

public class GameState {

    @SerializedName("hint_tokens")
    private int hintTokens;

    @SerializedName("hint_tokens_max")
    private int hintTokensMax;

    @SerializedName("err_tokens")
    private int errorTokens;

    @SerializedName("players")
    private List<Player> players;

    @SerializedName("played_cards")
    private HashMap<Color, Number> playedCards;

    @SerializedName("deck")
    private List<Card> deck;

    @SerializedName("discarded_cards")
    private List<Card> discardedCards;

    @SerializedName("next_player")
    private String nextPlayer;

    //OPTIONAL?!?!?
    @SerializedName("turns_left")
    private Integer turnsLeft;

    public int getHintTokens() {
        return hintTokens;
    }

    public int getHintTokensMax() {
        return hintTokensMax;
    }

    public int getErrorTokens() {
        return errorTokens;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public HashMap<Color, Number> getPlayedCards() {
        return playedCards;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public String getNextPlayer() {
        return nextPlayer;
    }

    @Override
    public String toString() {
        return "GameState [hintTokens=" + hintTokens + ", hintTokensMax=" + hintTokensMax + ", errorTokens=" + errorTokens + ", players=" + players
                + ", playedCards=" + playedCards + "]";
    }

}
