package de.novatec.cg.sc.hanabi.common.payload.handler.response;

import com.google.inject.Inject;
import com.google.inject.Singleton;

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

    public void handle(String json) {
        ConnectionResponse connectionResponse = jsonManager.fromJsonToObject(json, TARGET_TYPE);
        loggingService.logServerMessage("HANDLE CONNECTIONRESPONSE-->" + connectionResponse);
    }
}
