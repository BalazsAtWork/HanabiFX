package de.novatec.cg.sc.hanabi.common.response;

import de.novatec.cg.sc.hanabi.common.payload.handler.response.ResponseHandler;

public class GameOverResponse implements Response {

    private int score;

    public int getScore() {
        return score;
    }

    @Override
    public void handleWith(ResponseHandler responseHandler) {
        responseHandler.handle(this);
    }
}
