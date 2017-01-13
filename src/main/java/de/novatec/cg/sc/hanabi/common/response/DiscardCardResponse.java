package de.novatec.cg.sc.hanabi.common.response;

public class DiscardCardResponse extends GameStateResponse {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DiscardCardResponse [name=" + name + "]";
    }
}
