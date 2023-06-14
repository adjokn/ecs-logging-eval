package de.suedleasing.ecsloggingtest;

import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectMessage;
import org.apache.logging.log4j.message.StringMapMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EcsLoggingTestApplication {

    private static final Logger LOGGER = LogManager.getLogger(EcsLoggingTestApplication.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EcsLoggingTestApplication.class, args);

        try {
            throw new RuntimeException("final test exception");
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage(), 123, e);
        }
    }

    @PostConstruct
    public static void test() {
        LOGGER.info("just a text message");
        LOGGER.trace("trace message");
        LOGGER.debug("debug message");
        LOGGER.warn("warn message");
        LOGGER.error("error message");
        LOGGER.fatal("fatal message");

        LOGGER.info(new StringMapMessage().with("message", "StringMapMessage() test"));

        LOGGER.info(new ObjectMessage(new MyMessage()));


        LOGGER.info("last log message");
    }
}
