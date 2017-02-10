package de.novatec.cg.sc.hanabi.common.response;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.Card;

public class DiscardCardResponse extends GameStateResponse {

    @SerializedName("discarding_player")
    private String discardingPlayer;

    @SerializedName("discarded_card")
    private Card discardedCard;

    @SerializedName("drawn_card")
    private Card drawnCard;

    public String getDiscardingPlayer() {
        return discardingPlayer;
    }

    public Card getDiscardedCard() {
        return discardedCard;
    }

    public Card getDrawnCard() {
        return drawnCard;
    }
    @Override
    public String toString() {
        return "DiscardCardResponse [discardingPlayer=" + discardingPlayer + ", discardedCard=" + discardedCard + ", drawnCard=" + drawnCard + "]";
    }
}
