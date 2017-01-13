package de.novatec.cg.sc.hanabi.common.response;

public class ConnectionResponse implements Response {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ConnectionResponse [name=" + name + "]";
    }
}
