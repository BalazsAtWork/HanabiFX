package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import de.novatec.cg.sc.hanabi.common.response.ConnectionResponse;
import de.novatec.cg.sc.hanabi.common.response.DiscardCardResponse;
import de.novatec.cg.sc.hanabi.common.response.ErrorResponse;
import de.novatec.cg.sc.hanabi.common.response.GameOverResponse;
import de.novatec.cg.sc.hanabi.common.response.GameStartResponse;
import de.novatec.cg.sc.hanabi.common.response.HintColorResponse;
import de.novatec.cg.sc.hanabi.common.response.HintNumberResponse;
import de.novatec.cg.sc.hanabi.common.response.PlayCardResponse;

public interface ResponseHandler {
    void handle(ConnectionResponse connectionResponse);

    void handle(HintNumberResponse hintNumberResponse);

    void handle(HintColorResponse hintColorResponse);

    void handle(PlayCardResponse playCardResponse);

    void handle(DiscardCardResponse discardCardResponse);

    void handle(ErrorResponse errorResponse);

    void handle(GameOverResponse gameOverResponse);

    void handle(GameStartResponse gameStartResponse);
}
