package de.novatec.cg.sc.hanabi.common.response;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.payload.handler.response.ResponseHandler;

public class ErrorResponse implements Response {

    private String explanation;

    @SerializedName("err_details")
    private String errDetails;

    public String getExplanation() {
        return explanation;
    }

    public String getErrDetails() {
        return errDetails;
    }

    @Override
    public void handleWith(ResponseHandler responseHandler) {
        responseHandler.handle(this);
    }

    @Override
    public String toString() {
        return "ErrorResponse [explanation=" + explanation + ", errDetails=" + errDetails + "]";
    }
}
