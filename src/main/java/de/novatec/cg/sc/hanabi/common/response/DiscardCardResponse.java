package de.novatec.cg.sc.hanabi.common.response;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.ResponseHandler;

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
    public void handleWith(ResponseHandler responseHandler) {
        responseHandler.handle(this);
    }

    @Override
    public String toString() {
        return "DiscardCardResponse [discardingPlayer=" + discardingPlayer + ", discardedCard=" + discardedCard + ", drawnCard=" + drawnCard + "]";
    }
}
