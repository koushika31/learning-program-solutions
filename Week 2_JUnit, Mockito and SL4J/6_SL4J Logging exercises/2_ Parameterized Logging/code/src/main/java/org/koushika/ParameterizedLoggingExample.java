package org.koushika;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);
    public static void main(String[] args) {
        String user = "Koushika";
        int failedAttempts = 2;

        logger.info("User {} has logged in.", user);
        logger.warn("User {} failed {} login attempts.", user, failedAttempts);
        logger.error("Login error for user: {}", user);
    }
}
