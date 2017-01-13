package de.novatec.cg.sc.hanabi.common.response;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.GameState;

public abstract class GameStateResponse implements Response {

    @SerializedName("next_player")
    private String nextPlayerName;

    @SerializedName("game_state")
    private GameState gameState;

    public String getNextPlayerName() {
        return nextPlayerName;
    }

    public GameState getGameState() {
        return gameState;
    }
}
