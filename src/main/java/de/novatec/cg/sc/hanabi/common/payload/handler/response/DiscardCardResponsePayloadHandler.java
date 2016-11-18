package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.response.DiscardCardResponse;
import de.novatec.cg.sc.hanabi.common.service.JsonService;
import de.novatec.cg.sc.hanabi.common.service.LoggingService;

@Singleton
public class DiscardCardResponsePayloadHandler {

    private static final Class<DiscardCardResponse> TARGET_TYPE = DiscardCardResponse.class;

    @Inject
    private JsonService jsonManager;

    @Inject
    private LoggingService loggingService;

    public void handle(String json) {
        DiscardCardResponse discardCardResponse = jsonManager.fromJsonToObject(json, TARGET_TYPE);
        loggingService.logServerMessage("HANDLE DISCARDCARD RESPONSE-->" + discardCardResponse);
    }
}
