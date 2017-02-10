package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

public class PlayCardRequest implements Request {

    @SerializedName("played_card_id")
    private final int playedCardId;

    public PlayCardRequest(int playedCardId) {
        this.playedCardId = playedCardId;
    }

    @Override
    public String toString() {
        return "PlaycardRequest [playedCardId=" + playedCardId + "]";
    }
}
