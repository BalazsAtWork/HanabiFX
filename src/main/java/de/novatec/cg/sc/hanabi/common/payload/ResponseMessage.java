package de.novatec.cg.sc.hanabi.common.payload;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.GameState;
import de.novatec.cg.sc.hanabi.common.enums.ResponseType;

public class ResponseMessage {

    @SerializedName("res_type")
    private ResponseType responseType;

    @SerializedName("payload")
    private String payload;

    @SerializedName("game_state")
    private GameState gameState;

    public ResponseType getReponseType() {
        return responseType;
    }

    public String getPayload() {
        return payload;
    }

    public GameState getGameState() {
        return gameState;
    }

    @Override
    public String toString() {
        return "ResponseMessage [responseType=" + responseType + ", payload=" + payload + "]";
    }
}
