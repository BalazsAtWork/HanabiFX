package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.GameState;
import de.novatec.cg.sc.hanabi.common.service.JsonService;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

@Singleton
public class GameStatePayloadHandler {

    private static final Class<GameState> TARGET_TYPE = GameState.class;

    @Inject
    private JsonService jsonManager;

    @Inject
    private LoggingService loggingService;

    public void handle(String json) {
        GameState gameState = jsonManager.fromJsonToObject(json, TARGET_TYPE);
        loggingService.logClientMessage("HANDLE GAMESTATE-->" + gameState);
    }
}
