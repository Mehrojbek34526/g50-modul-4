package uz.pdp.lesson10;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 Created by: Mehrojbek
 DateTime: 25/01/25 21:53
 **/
public class TelegramHandler extends StreamHandler {

    @Override
    public boolean isLoggable(LogRecord record) {
        return record.getLevel() == Level.SEVERE;
    }

    @Override
    public synchronized void publish(LogRecord record) {

        String text = this.getFormatter().format(record);

        SendMessage message = new SendMessage(
                "354668188",
                text
        );

        TgSender tgSender = TgSender.getInstance();
        try {
            tgSender.execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
