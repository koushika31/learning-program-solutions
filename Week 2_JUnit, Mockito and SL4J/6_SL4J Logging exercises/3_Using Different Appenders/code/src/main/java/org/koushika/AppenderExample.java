package org.koushika;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);
    public static void main(String[] args) {
        logger.info("Logging to both console and file.");
        logger.warn("This is a warning that should appear in both.");
        logger.error("This is an error message with dual appenders.");
    }
}
