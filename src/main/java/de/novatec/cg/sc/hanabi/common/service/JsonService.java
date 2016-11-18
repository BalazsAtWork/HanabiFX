package de.novatec.cg.sc.hanabi.common.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class JsonService {

    @Inject
    private LoggingService loggingService;

    private Gson gson = new GsonBuilder().serializeNulls().create();

    public String fromObjectToJson(Object obj) {
        String json = gson.toJson(obj);
        loggingService.logClientMessage("fromObject:" + obj + " to Json: " + json);
        return json;
    }

    public <T> T fromJsonToObject(String json, Class<T> type) {
        T obj = gson.fromJson(json, type);
        loggingService.logClientMessage("fromJson:" + json + " to Object: " + obj);
        return obj;
    }
}
