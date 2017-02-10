package de.novatec.cg.sc.hanabi.common.response;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.ResponseHandler;

public class HintColorResponse extends GameStateResponse {

    @SerializedName("hinting_player")
    private String hintingPlayer;

    @SerializedName("target_player")
    private String targetPlayer;

    @SerializedName("hinted_color")
    private Color hintedColor;

    public String getHintingPlayer() {
        return hintingPlayer;
    }

    public String getTargetPlayer() {
        return targetPlayer;
    }

    public Color getHintedColor() {
        return hintedColor;
    }

    @Override
    public void handleWith(ResponseHandler responseHandler) {
        responseHandler.handle(this);
    }
}
