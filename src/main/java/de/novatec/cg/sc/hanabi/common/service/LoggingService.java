package de.novatec.cg.sc.hanabi.common.service;

import java.util.logging.Logger;

import com.google.inject.Singleton;

@Singleton
public final class LoggingService {
    private final Logger logger = Logger.getLogger(LoggingService.class.getName());

    public void logServerMessage(String message) {
        logger.info("SERVER: " + message);
    }

    public void logClientMessage(String message) {
        logger.info("CLIENT: " + message);
    }
}
