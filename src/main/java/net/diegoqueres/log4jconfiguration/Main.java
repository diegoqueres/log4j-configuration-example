package net.diegoqueres.log4jconfiguration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        initNdcConfiguration();

        String message = "Hello there!";
        System.out.println(message);
        logger.debug(message);
        logger.info(message);
        logger.error(message);

        LoggerChild.log();

        finishNdcConfiguration();
    }

    static void initNdcConfiguration() {
        //Irá prover uma saída com identificação, como o exemplo: 10:04:35.097 [main] [admin, 1234] ERROR com.company.Main ...
        String username = "admin";
        String sessionId = "1234";

        ThreadContext.push(username);
        ThreadContext.push(sessionId);
    }

    static void finishNdcConfiguration() {
        ThreadContext.pop();
        ThreadContext.removeStack();
    }

    private static class LoggerChild {
        private static final Logger childLogger = LogManager.getLogger(LoggerChild.class);

        static void log() {
            childLogger.debug("Hi Mom!");
        }
    }
}