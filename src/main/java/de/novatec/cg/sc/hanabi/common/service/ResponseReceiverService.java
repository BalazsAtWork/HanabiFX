package de.novatec.cg.sc.hanabi.common.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.payload.ResponseMessage;
import de.novatec.cg.sc.hanabi.common.payload.handler.ResponseMessageHandler;

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
        ResponseMessage responseMessage = jsonService.fromJsonToObject(message, ResponseMessage.class);
        responseMessageHandler.handle(responseMessage);
    }
}
