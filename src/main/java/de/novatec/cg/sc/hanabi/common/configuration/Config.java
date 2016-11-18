package de.novatec.cg.sc.hanabi.common.configuration;

public class Config {

    //    public static final String HOST_NAME = "localhost";
    public static final String HOST_NAME = "192.168.101.25";
    public static final int SERVER_PORT = 4444;
    public static final String SERVER_URI = "ws://" + HOST_NAME + ":" + SERVER_PORT;

    private Config() {
        // NO INSTANCE REQUIRED
    }
}
