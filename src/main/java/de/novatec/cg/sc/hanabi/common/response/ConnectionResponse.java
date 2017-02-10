package de.novatec.cg.sc.hanabi.common.response;

import java.util.List;

import de.novatec.cg.sc.hanabi.common.payload.handler.response.ResponseHandler;

public class ConnectionResponse implements Response {

    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    @Override
    public void handleWith(ResponseHandler responseHandler) {
        responseHandler.handle(this);
    }

    @Override
    public String toString() {
        return "ConnectionResponse [names=" + names + "]";
    }
}
