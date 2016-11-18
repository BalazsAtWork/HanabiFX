package de.novatec.cg.sc.hanabi.common.service;

import com.google.inject.Singleton;

@Singleton
public final class LoggingService {
    //    Logger.getLogger(HanabiClientEndpoint.class.getName()).log(Level.SEVERE, null, ex);

    public void logServerMessage(String message) {
        System.out.println("SERVER: " + message);
    }

    public void logClientMessage(String message) {
        System.out.println("CLIENT: " + message);
    }
}
