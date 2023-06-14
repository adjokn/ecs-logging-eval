package de.suedleasing.ecsloggingtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
public class EcsLoggingTestController {
    private static final Logger LOGGER = LogManager.getLogger(EcsLoggingTestController.class);

    @Scheduled(fixedRate = 1000)
    public void testTask() {
        try {
            LOGGER.info("test task");
            int i = 7 / 0;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
