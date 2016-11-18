package de.novatec.cg.sc.hanabi.common.payload.handler;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.enums.ResponseType;
import de.novatec.cg.sc.hanabi.common.payload.ResponseMessage;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.ConnectionResponsePayloadHandler;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.DiscardCardResponsePayloadHandler;
import de.novatec.cg.sc.hanabi.common.payload.handler.response.PlayCardResponsePayloadHandler;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

@Singleton
public class ResponseMessageHandler {

    @Inject
    private ConnectionResponsePayloadHandler connectionResponsePayloadHandler;

    @Inject
    private DiscardCardResponsePayloadHandler discardCardResponsePayloadHandler;

    @Inject
    private PlayCardResponsePayloadHandler playCardResponsePayloadHandler;

    @Inject
    private LoggingService loggingService;

    public void handle(ResponseMessage responseMessage) {
        ResponseType responseType = responseMessage.getReponseType();
        String payload = responseMessage.getPayload();

        switch (responseType) {
        case ERROR_RESPONSE:
            loggingService.logClientMessage("ERROR OCCURED: " + payload);
            break;
        case CONNECTION_RESPONSE:
            connectionResponsePayloadHandler.handle(payload);
            break;
        case DISCARD_CARD_RESPONSE:
            discardCardResponsePayloadHandler.handle(payload);
            break;
        case HINT_COLOR_RESPONSE:
            System.out.println("-HINT_COLOR_RESPONSE->" + payload);
            break;
        case HINT_NUMBER_RESPONSE:
            System.out.println("-HINT_NUMBER_RESPONSE->" + payload);
            break;
        case PLAY_CARD_RESPONSE:
            playCardResponsePayloadHandler.handle(payload);
            break;
        case GAME_OVER_RESPONSE:
            System.out.println("-GAME_OVER_RESPONSE->" + payload);
            break;
        }
    }
}
