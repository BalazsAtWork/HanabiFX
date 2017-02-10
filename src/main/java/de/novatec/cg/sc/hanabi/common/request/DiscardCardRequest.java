package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

public class DiscardCardRequest implements Request {

    @SerializedName("discarded_card_id")
    private final int discardedCardId;

    public DiscardCardRequest(int discardedCardId) {
        this.discardedCardId = discardedCardId;
    }

    @Override
    public String toString() {
        return "DiscardCardRequest [discardedCardId=" + discardedCardId + "]";
    }
}
