package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.enums.RequestType;

public class PlayCardRequest implements Request {

    @SerializedName("played_card")
    private final Card card;

    public PlayCardRequest(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "PlaycardRequest [card=" + card + "]";
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.PLAY_CARD_REQUEST;
    }
}
