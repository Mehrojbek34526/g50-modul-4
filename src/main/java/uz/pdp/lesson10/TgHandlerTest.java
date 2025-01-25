package uz.pdp.lesson10;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 Created by: Mehrojbek
 DateTime: 25/01/25 21:56
 **/
public class TgHandlerTest {

    public static Logger logger = Logger.getLogger(TgHandlerTest.class.getName());

    public static void main(String[] args) {

        TelegramHandler telegramHandler = new TelegramHandler();

        MyLogFormatter formatter = new MyLogFormatter();

        telegramHandler.setFormatter(formatter);

        logger.addHandler(telegramHandler);

        logger.info("This is and not sent telegram");

        exceptionTest();

    }

    private static void exceptionTest() {
        try {

            if (true)
                throw new RuntimeException("This specific exception");

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

}
