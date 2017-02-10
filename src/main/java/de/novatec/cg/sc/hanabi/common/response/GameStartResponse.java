package de.novatec.cg.sc.hanabi.common.response;

import de.novatec.cg.sc.hanabi.common.payload.handler.response.ResponseHandler;

public class GameStartResponse extends GameStateResponse {

    @Override
    public void handleWith(ResponseHandler responseHandler) {
        responseHandler.handle(this);
    }
}
