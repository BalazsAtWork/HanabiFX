package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.RequestType;

public class PlayCardRequest implements Request {

    @SerializedName("played_card_id")
    private final int playedCardId;

    public PlayCardRequest(int playedCardId) {
        this.playedCardId = playedCardId;
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.PLAY_CARD_REQUEST;
    }

    @Override
    public String toString() {
        return "PlaycardRequest [playedCardId=" + playedCardId + "]";
    }
}
