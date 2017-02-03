package de.novatec.cg.sc.hanabi.common.payload.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.client.fx.renderer.GameStateRenderer;
import de.novatec.cg.sc.hanabi.common.GameState;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.ConnectionResponseHandler;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.DiscardCardResponseHandler;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.ErrorResponseHandler;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.GameOverResponseHandler;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.PlayCardResponseHandler;
import de.novatec.cg.sc.hanabi.common.response.ConnectionResponse;
import de.novatec.cg.sc.hanabi.common.response.ErrorResponse;
import de.novatec.cg.sc.hanabi.common.response.GameOverResponse;
import de.novatec.cg.sc.hanabi.common.response.GameStateResponse;
import de.novatec.cg.sc.hanabi.common.response.Response;
import javafx.application.Platform;

@Singleton
public class ResponseMessageHandler {

    @Inject
    private ConnectionResponseHandler connectionResponseHandler;

    @Inject
    private DiscardCardResponseHandler discardcardresponsepayloadhandler;

    @Inject
    private PlayCardResponseHandler playCardResponsePayloadHandler;

    @Inject
    private ErrorResponseHandler errorResponsePayloadHandler;

    @Inject
    private GameOverResponseHandler gameOverResponsePayloadHandler;

    @Inject
    private GameStateRenderer gameStateRenderer;

    public void handle(Response response) {

        if (response instanceof ErrorResponse) {
            errorResponsePayloadHandler.handle((ErrorResponse) response);
        } else if (response instanceof ConnectionResponse) {
            connectionResponseHandler.handle((ConnectionResponse) response);
            //            renderGameState(response);
        } else if (response instanceof GameStateResponse) {
            renderGameState((GameStateResponse) response);
        } else if (response instanceof GameOverResponse) {
            gameOverResponsePayloadHandler.handle((GameOverResponse) response);
            //            renderGameState(response);
        }
    }

    private void renderGameState(GameStateResponse gameStateResponse) {
        Platform.runLater(() -> {
            GameState gameState = gameStateResponse.getGameState();
            String nextPlayerName = gameState.getNextPlayer();
            gameStateRenderer.renderGameState(gameState, nextPlayerName);
        });
    }
}
