package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.Card;
import de.novatec.cg.sc.hanabi.common.enums.RequestType;

public class DiscardCardRequest implements Request {

    @SerializedName("discarded_card")
    private final Card discardedCard;

    public DiscardCardRequest(Card card) {
        this.discardedCard = card;
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.DISCARD_REQUEST;
    }

    @Override
    public String toString() {
        return "DiscardCardRequest [discardedCard=" + discardedCard + "]";
    }
}
