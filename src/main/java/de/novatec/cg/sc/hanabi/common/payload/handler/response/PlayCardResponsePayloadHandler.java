package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.response.PlayCardResponse;
import de.novatec.cg.sc.hanabi.common.service.JsonService;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

@Singleton
public class PlayCardResponsePayloadHandler {

    private static final Class<PlayCardResponse> TARGET_TYPE = PlayCardResponse.class;

    @Inject
    private JsonService jsonManager;

    @Inject
    private LoggingService loggingService;

    public void handle(String json) {
        PlayCardResponse playCardResponse = jsonManager.fromJsonToObject(json, TARGET_TYPE);
        loggingService.logClientMessage("HANDLE PLAYCARDRESPONSE-->" + playCardResponse);
    }
}
