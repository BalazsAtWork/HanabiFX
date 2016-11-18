package de.novatec.cg.sc.hanabi.common.payload;

import com.google.gson.annotations.SerializedName;

import de.novatec.cg.sc.hanabi.common.enums.RequestType;

public class RequestMessage {

    @SerializedName("req_type")
    private final RequestType payloadType;

    private final String payload;

    public RequestMessage(RequestType payloadType, String payload) {
        this.payloadType = payloadType;
        this.payload = payload;
    }

    public RequestType getPayloadType() {
        return payloadType;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "RequestMessage [payloadType=" + payloadType + ", payload=" + payload + "]";
    }
}
