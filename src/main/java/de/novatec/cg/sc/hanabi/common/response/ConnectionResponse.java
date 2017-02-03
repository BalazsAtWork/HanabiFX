package de.novatec.cg.sc.hanabi.common.response;

import java.util.List;

public class ConnectionResponse implements Response {

    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        return "ConnectionResponse [names=" + names + "]";
    }
}
