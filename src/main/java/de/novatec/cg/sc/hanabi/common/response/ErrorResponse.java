package de.novatec.cg.sc.hanabi.common.response;

public class ErrorResponse implements Response {

    private String explanation;

    public String getExplanation() {
        return explanation;
    }

    @Override
    public String toString() {
        return "ErrorResponse [explanation=" + explanation + "]";
    }
}
