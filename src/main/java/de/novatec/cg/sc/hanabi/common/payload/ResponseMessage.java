package de.novatec.cg.sc.hanabi.common.payload;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.ResponseType;

public class ResponseMessage {

    @SerializedName("res_type")
    private final ResponseType responseType;

    private final String payload;

    public ResponseMessage(ResponseType responseType, String payload) {
        this.responseType = responseType;
        this.payload = payload;
    }

    public ResponseType getReponseType() {
        return responseType;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "ResponseMessage [responseType=" + responseType + ", payload=" + payload + "]";
    }
}
