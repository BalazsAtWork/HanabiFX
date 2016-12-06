package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.client.fx.renderer.GameStateRenderer;
import de.novatec.cg.sc.hanabi.common.response.ConnectionResponse;
import de.novatec.cg.sc.hanabi.common.service.JsonService;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

@Singleton
public class ConnectionResponsePayloadHandler {

    private static final Class<ConnectionResponse> TARGET_TYPE = ConnectionResponse.class;

    @Inject
    private JsonService jsonManager;

    @Inject
    private LoggingService loggingService;

    @Inject
    private GameStateRenderer gameStateRenderer;

    private List<String> connectedPlayerNames = new ArrayList<>();

    public void handle(String json) {
        ConnectionResponse connectionResponse = jsonManager.fromJsonToObject(json, TARGET_TYPE);
        loggingService.logClientMessage("HANDLE CONNECTIONRESPONSE-->" + connectionResponse);
        gameStateRenderer.setCurrentPlayerName(connectionResponse.getName());

        connectedPlayerNames.add(connectionResponse.getName());
    }
}
