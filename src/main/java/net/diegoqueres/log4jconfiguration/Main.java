package net.diegoqueres.log4jconfiguration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        String message = "Hello there!";
        System.out.println(message);
        logger.debug(message);
        logger.info(message);
        logger.error(message);

        LoggerChild.log();
    }

    private static class LoggerChild {
        private static final Logger childLogger = LogManager.getLogger(LoggerChild.class);

        static void log() {
            childLogger.debug("Hi Mom!");
        }
    }
}