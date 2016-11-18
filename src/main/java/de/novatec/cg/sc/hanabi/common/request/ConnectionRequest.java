package de.novatec.cg.sc.hanabi.common.request;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.RequestType;

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

    @Override
    public RequestType getRequestType() {
        return RequestType.CONNECTION_REQUEST;
    }
}
