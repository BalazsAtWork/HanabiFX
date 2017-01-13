package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.Color;
import de.novatec.cg.sc.hanabi.common.enums.RequestType;

public class HintColorRequest implements Request {

    @SerializedName("target_player")
    private final String targetPlayer;

    @SerializedName("color")
    private final Color color;

    public HintColorRequest(String targetPlayer, Color color) {
        this.targetPlayer = targetPlayer;
        this.color = color;
    }

    @Override
    public RequestType getRequestType() {
        return RequestType.HINT_COLOR_REQUEST;
    }

    @Override
    public String toString() {
        return "HintColorRequest [targetPlayer=" + targetPlayer + ", color=" + color + "]";
    }
}
