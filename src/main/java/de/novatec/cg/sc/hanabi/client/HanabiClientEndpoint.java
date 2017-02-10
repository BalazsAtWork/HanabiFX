package de.novatec.cg.sc.hanabi.client;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;
import de.novatec.cg.sc.hanabi.common.service.RequestSenderService;
import de.novatec.cg.sc.hanabi.common.service.ResponseReceiverService;

@ClientEndpoint
public class HanabiClientEndpoint {

    @Inject
    private LoggingService loggingService;

    @Inject
    private ResponseReceiverService responseReceiverService;

    @Inject
    private RequestSenderService requestSender;

    public HanabiClientEndpoint() {
        GuiceInjector.injectMembersInto(this);
    }

    @OnOpen
    public void onOpen(Session session) {
        keepConnectionAlive(session);
        loggingService.logClientMessage("Opened connected to endpoint: " + session.getBasicRemote());
        requestSender.setMessageSender(session.getBasicRemote());
    }

    @OnMessage
    public void processMessage(String message) {
        responseReceiverService.handleServerMessage(message);
    }

    @OnError
    public void processError(Throwable t) {
        loggingService.logClientMessage("ERROR OCCURED: " + t);
    }

    @OnClose
    public void closed() {
        loggingService.logClientMessage("Connection to server closed!");
    }

    private void keepConnectionAlive(Session session) {
        session.setMaxIdleTimeout(-1);
    }
}
