package de.novatec.cg.sc.hanabi.common.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.novatec.cg.sc.hanabi.common.enums.RequestType;
import de.novatec.cg.sc.hanabi.common.enums.ResponseType;
import de.novatec.cg.sc.hanabi.common.request.ConnectionRequest;
import de.novatec.cg.sc.hanabi.common.request.DiscardCardRequest;
import de.novatec.cg.sc.hanabi.common.request.GameStartRequest;
import de.novatec.cg.sc.hanabi.common.request.HintColorRequest;
import de.novatec.cg.sc.hanabi.common.request.HintNumberRequest;
import de.novatec.cg.sc.hanabi.common.request.PlayCardRequest;
import de.novatec.cg.sc.hanabi.common.request.Request;
import de.novatec.cg.sc.hanabi.common.response.ConnectionResponse;
import de.novatec.cg.sc.hanabi.common.response.DiscardCardResponse;
import de.novatec.cg.sc.hanabi.common.response.ErrorResponse;
import de.novatec.cg.sc.hanabi.common.response.GameOverResponse;
import de.novatec.cg.sc.hanabi.common.response.GameStartResponse;
import de.novatec.cg.sc.hanabi.common.response.HintColorResponse;
import de.novatec.cg.sc.hanabi.common.response.HintNumberResponse;
import de.novatec.cg.sc.hanabi.common.response.PlayCardResponse;
import de.novatec.cg.sc.hanabi.common.response.Response;

@Singleton
public class JsonService {

    @Inject
    private LoggingService loggingService;

    RuntimeTypeAdapterFactory<Request> requestAdapter = RuntimeTypeAdapterFactory.of(Request.class, "msg_type")
            .registerSubtype(ConnectionRequest.class, RequestType.CONNECTION_REQUEST.name())
            .registerSubtype(GameStartRequest.class, RequestType.GAME_START_REQUEST.name())
            .registerSubtype(PlayCardRequest.class, RequestType.PLAY_CARD_REQUEST.name())
            .registerSubtype(DiscardCardRequest.class, RequestType.DISCARD_REQUEST.name())
            .registerSubtype(HintColorRequest.class, RequestType.HINT_COLOR_REQUEST.name())
            .registerSubtype(HintNumberRequest.class, RequestType.HINT_NUMBER_REQUEST.name());

    RuntimeTypeAdapterFactory<Response> responseAdapter = RuntimeTypeAdapterFactory.of(Response.class, "msg_type")
            .registerSubtype(ConnectionResponse.class, ResponseType.CONNECTION_RESPONSE.name())
            .registerSubtype(GameStartResponse.class, ResponseType.GAME_START_RESPONSE.name())
            .registerSubtype(PlayCardResponse.class, ResponseType.PLAY_CARD_RESPONSE.name())
            .registerSubtype(DiscardCardResponse.class, ResponseType.DISCARD_CARD_RESPONSE.name())
            .registerSubtype(HintColorResponse.class, ResponseType.HINT_COLOR_RESPONSE.name())
            .registerSubtype(HintNumberResponse.class, ResponseType.HINT_NUMBER_RESPONSE.name())
            .registerSubtype(GameOverResponse.class, ResponseType.GAME_OVER_RESPONSE.name())
            .registerSubtype(ErrorResponse.class, ResponseType.ERROR_RESPONSE.name());

    private Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapterFactory(requestAdapter).registerTypeAdapterFactory(responseAdapter).create();

    public String fromObjectToJson(Object obj, Class<?> clazz) {
        String json = gson.toJson(obj, clazz);
        loggingService.logClientMessage("fromObject:" + obj + " to Json: " + json);
        return json;
    }

    public <T> T fromJsonToObject(String json, Class<T> type) {
        T obj = gson.fromJson(json, type);
        loggingService.logClientMessage("fromJson:" + json + " to Object: " + obj);
        return obj;
    }
}
