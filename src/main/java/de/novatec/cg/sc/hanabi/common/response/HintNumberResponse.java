package de.novatec.cg.sc.hanabi.common.response;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Number;
public class HintNumberResponse extends GameStateResponse {

    @SerializedName("hinting_player")
    private String hintingPlayer;

    @SerializedName("target_player")
    private String targetPlayer;

    @SerializedName("hinted_number")
    private Number hintedNumber;

    public String getHintingPlayer() {
        return hintingPlayer;
    }

    public String getTargetPlayer() {
        return targetPlayer;
    }

    public Number getHintedNumber() {
        return hintedNumber;
    }

}
