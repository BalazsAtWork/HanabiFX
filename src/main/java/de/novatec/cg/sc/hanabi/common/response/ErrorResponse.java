package de.novatec.cg.sc.hanabi.common.response;

import com.google.gson.annotations.SerializedName;

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
    public String toString() {
        return "ErrorResponse [explanation=" + explanation + ", errDetails=" + errDetails + "]";
    }

}
