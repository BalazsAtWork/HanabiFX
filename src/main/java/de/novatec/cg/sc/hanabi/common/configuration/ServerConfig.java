package de.novatec.cg.sc.hanabi.common.configuration;

import com.google.inject.Singleton;

@Singleton
public class ServerConfig implements Config {

    private String hostName;

    private int port;

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String getServerURI() {
        return "ws://" + hostName + ":" + port;
    }
}
