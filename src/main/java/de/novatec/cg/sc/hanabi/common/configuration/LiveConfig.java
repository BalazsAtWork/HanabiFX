package de.novatec.cg.sc.hanabi.common.configuration;

public class LiveConfig implements Config {

    private static final String HOST_NAME = "192.168.101.25";
    private static final int SERVER_PORT = 4444;
    private static final String SERVER_URI = "ws://" + HOST_NAME + ":" + SERVER_PORT;

    @Override
    public String getServerURI() {
        return SERVER_URI;
    }
}
