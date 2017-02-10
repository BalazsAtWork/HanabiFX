package de.novatec.cg.sc.hanabi.common.response;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.ResponseHandler;

public class PlayCardResponse extends GameStateResponse {

    @SerializedName("playing_player")
    private String playingPlayer;

    @SerializedName("played_card")
    private Card playedCard;

    @SerializedName("drawn_card")
    private Card drawnCard;

    @SerializedName("success")
    private boolean success;

    public String getPlayingPlayer() {
        return playingPlayer;
    }

    public Card getPlayedCard() {
        return playedCard;
    }

    public Card getDrawnCard() {
        return drawnCard;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public void handleWith(ResponseHandler responseHandler) {
        responseHandler.handle(this);
    }

    @Override
    public String toString() {
        return "PlayCardResponse [playingPlayer=" + playingPlayer + ", playedCard=" + playedCard + ", drawnCard=" + drawnCard + ", success=" + success + "]";
    }
}
