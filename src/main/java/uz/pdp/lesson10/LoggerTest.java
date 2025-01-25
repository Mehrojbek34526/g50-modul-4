package uz.pdp.lesson10;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.*;

/**
 Created by: Mehrojbek
 DateTime: 25/01/25 20:09
 **/
public class LoggerTest {

//    static {
//        System.setProperty(
//                "java.util.logging.config.file",
//                "/Users/mehrojbekmavlonov/IdeaProjects/g50-modul-4/src/main/resources/logging.properties"
//        );
//    }

    ///Users/mehrojbekmavlonov/IdeaProjects/g50-modul-4/src/main/resources/logging.properties
    public static Logger logger = Logger.getLogger(LoggerTest.class.getName());

    public static void main(String[] args) throws IOException {

        logger.setLevel(Level.INFO);

        FileHandler fileHandler = new FileHandler("logs/fileLog.txt");

        TelegramHandler telegramHandler = new TelegramHandler();

//        Formatter formatter = new SimpleFormatter();
        Formatter formatter = new MyLogFormatter();

        fileHandler.setFormatter(formatter);

        logger.addHandler(fileHandler);
        logger.addHandler(telegramHandler);

//        logger.log(Level.INFO, "This Warning log test");

        LogRecord logRecord = new LogRecord(Level.INFO, "Bu Log record orqali yozildi ");

//        logger.log(logRecord);
//
//        logger.info("Info ...");
//
//        logger.severe("Severe ...");
//
//        logger.warning("Warning ...");

        exception();

    }

    private static void exception() {
        try {
            if (new Random().nextBoolean()) {
                throw new RuntimeException("This is a test");
            }
        } catch (RuntimeException e) {

            logger.log(Level.SEVERE, "Exception ", e);

            throw new RuntimeException(e);
        }
    }

}
