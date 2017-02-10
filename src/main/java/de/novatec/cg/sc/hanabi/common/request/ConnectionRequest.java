package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

public class ConnectionRequest implements Request {

    @SerializedName("name")
    private final String playerName;

    public ConnectionRequest(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "ConnectionRequest [playerName=" + playerName + "]";
    }
}
