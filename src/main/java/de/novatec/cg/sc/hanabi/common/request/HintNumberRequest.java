package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Number;

public class HintNumberRequest implements Request {

    @SerializedName("target_player")
    private final String targetPlayer;

    @SerializedName("number")
    private final Number number;

    public HintNumberRequest(String targetPlayer, Number number) {
        this.targetPlayer = targetPlayer;
        this.number = number;
    }

    @Override
    public String toString() {
        return "HintNumberRequest [targetPlayer=" + targetPlayer + ", number=" + number + "]";
    }
}
