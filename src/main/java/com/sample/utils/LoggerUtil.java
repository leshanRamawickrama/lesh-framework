package com.sample.utils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    Logger logger;

    public LoggerUtil(Class clazz) {
        logger = LogManager.getLogger(clazz);
    }

    public void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public void logDebug(String message) {
        logger.log(Level.DEBUG, message);
    }

    public void logError(Throwable t) {
        logError(t.getMessage(), t);
    }

    public void logError(String message, Throwable t) {
        logger.log(Level.ERROR, message, t);
    }

}
