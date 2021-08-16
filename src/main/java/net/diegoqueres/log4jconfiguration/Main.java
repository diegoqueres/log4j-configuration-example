package net.diegoqueres.log4jconfiguration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        initMdcConfiguration();

        System.out.println("This is a console message");
        logger.debug("This is a debug log!");
        logger.info("This is an info log!");
        logger.error("This is an error log!");

        LoggerChild.log();

        finishMdcConfiguration();
    }

    static void initMdcConfiguration() {
        //Irá prover uma saída com identificação, como o exemplo: 10:04:35.097 [main] [admin, 1234] ERROR com.company.Main ...
        ThreadContext.put("username", "admin");
        ThreadContext.put("sessionID", "1234");
    }

    static void finishMdcConfiguration() {
        ThreadContext.clearMap();
    }

    private static class LoggerChild {
        private static final Logger childLogger = LogManager.getLogger(LoggerChild.class);

        static void log() {
            childLogger.debug("Hi Mom!");
        }
    }
}