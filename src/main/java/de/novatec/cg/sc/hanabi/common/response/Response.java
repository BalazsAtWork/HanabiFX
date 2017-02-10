package de.novatec.cg.sc.hanabi.common.response;

import de.novatec.cg.sc.hanabi.common.payload.handler.response.ResponseHandler;

public interface Response {
    void handleWith(ResponseHandler responseHandler);
}
