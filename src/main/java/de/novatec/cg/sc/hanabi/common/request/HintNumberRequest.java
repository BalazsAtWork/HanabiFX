package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Number;
import de.novatec.cg.sc.hanabi.common.enums.RequestType;

public class HintNumberRequest implements Request {

    @SerializedName("target_player")
    private final String targetPlayer;

    @SerializedName("number")
    private final Number number;

    @SerializedName("positive")
    private final boolean positive;

    public HintNumberRequest(String targetPlayer, Number number, boolean positive) {
        this.targetPlayer = targetPlayer;
        this.number = number;
        this.positive = positive;
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.HINT_NUMBER_REQUEST;
    }

    @Override
    public String toString() {
        return "HintNumberRequest [targetPlayer=" + targetPlayer + ", number=" + number + ", positive=" + positive + "]";
    }
}
