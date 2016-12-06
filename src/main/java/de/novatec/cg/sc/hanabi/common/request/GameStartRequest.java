package de.novatec.cg.sc.hanabi.common.request;

import de.novatec.cg.sc.hanabi.common.enums.RequestType;

public class GameStartRequest implements Request {

    @Override
    public RequestType getRequestType() {
        return RequestType.GAME_START_REQUEST;
    }

    @Override
    public String toString() {
        return "GameStartRequest []";
    }
}
