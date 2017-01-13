package de.novatec.cg.sc.hanabi.common.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.payload.handler.ResponseMessageHandler;
import de.novatec.cg.sc.hanabi.common.response.Response;

@Singleton
public class ResponseReceiverService {

    @Inject
    private LoggingService loggingService;

    @Inject
    private JsonService jsonService;

    @Inject
    private ResponseMessageHandler responseMessageHandler;

    public void handleServerMessage(String message) {
        loggingService.logClientMessage("Message from Server: " + message);
        Response response = jsonService.fromJsonToObject(message, Response.class);
        responseMessageHandler.handle(response);
    }
}
