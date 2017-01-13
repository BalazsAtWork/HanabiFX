package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.client.fx.renderer.GameStateRenderer;
import de.novatec.cg.sc.hanabi.common.response.ConnectionResponse;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;
import de.novatec.cg.sc.hanabi.common.service.RequestSenderService;

@Singleton
public class ConnectionResponseHandler {

    @Inject
    private LoggingService loggingService;

    @Inject
    private GameStateRenderer gameStateRenderer;

    @Inject
    private RequestSenderService requestSenderService;

    private List<String> connectedPlayerNames = new ArrayList<>();

    public void handle(ConnectionResponse connectionResponse) {
        loggingService.logClientMessage("HANDLE CONNECTIONRESPONSE-->" + connectionResponse);
        gameStateRenderer.setCurrentPlayerName(connectionResponse.getName());

        connectedPlayerNames.add(connectionResponse.getName());

        if (connectedPlayerNames.size() == 2) {
            requestSenderService.sendGameStartRequest();
        }
    }
}
