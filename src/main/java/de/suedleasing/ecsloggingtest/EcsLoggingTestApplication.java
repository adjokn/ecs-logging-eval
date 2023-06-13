package de.suedleasing.ecsloggingtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectMessage;
import org.apache.logging.log4j.message.StringMapMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EcsLoggingTestApplication {

    private static final Logger logger = LogManager.getLogger(EcsLoggingTestApplication.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EcsLoggingTestApplication.class, args);

        logger.info("just a text message");

        logger.info(new StringMapMessage().with("message", "StringMapMessage() test"));

        logger.info(new ObjectMessage(new MyMessage()));

        try {
            throw new RuntimeException("test Exception");
        } catch (RuntimeException e) {
            logger.error(e.toString(), 123, e);
        }
    }
}
