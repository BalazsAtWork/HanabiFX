package de.novatec.cg.sc.hanabi.client;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import com.google.inject.Inject;

import de.novatec.cg.sc.hanabi.GuiceInjector;
import de.novatec.cg.sc.hanabi.common.configuration.Config;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

public class Client {

    @Inject
    private LoggingService loggingService;

    @Inject
    private Config serverConfig;

    private Client() {
        GuiceInjector.injectMembersInto(this);
    }

    private final void connectAsClientToServer() {
        try {
            loggingService.logClientMessage("Connecting to " + serverConfig.getServerURI());
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(HanabiClientEndpoint.class, URI.create(serverConfig.getServerURI()));
        } catch (DeploymentException | IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static final void connectToServer() {
        new Client().connectAsClientToServer();
    }
}
