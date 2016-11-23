package de.novatec.cg.sc.hanabi.common.configuration;

public class LocalConfig implements Config {

    private static final String HOST_NAME = "localhost";
    private static final int SERVER_PORT = 4444;
    private static final String SERVER_URI = "ws://" + HOST_NAME + ":" + SERVER_PORT + "/hanabi";

    @Override
    public String getServerURI() {
        return SERVER_URI;
    }
}
