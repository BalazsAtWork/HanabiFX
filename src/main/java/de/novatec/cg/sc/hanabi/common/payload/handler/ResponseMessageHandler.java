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

    public void handle(ResponseMessage payloadContainer) {
        ResponseType responseType = payloadContainer.getReponseType();
        String payload = payloadContainer.getPayload();

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
        case PLAY_CARD_RESPONSE:
            playCardResponsePayloadHandler.handle(payload);
            break;
        default:
            break;
        }
        throw new IllegalArgumentException("UNHANDLED PAYLOADTYPE!");
    }
}
