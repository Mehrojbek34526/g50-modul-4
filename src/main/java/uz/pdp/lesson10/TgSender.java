package uz.pdp.lesson10;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

/**
 Created by: Mehrojbek
 DateTime: 25/01/25 22:01
 **/
public class TgSender extends DefaultAbsSender {

    protected TgSender(DefaultBotOptions options, String botToken) {
        super(options, botToken);
    }

    //testTg513980bot
    public static TgSender getInstance() {
        return new TgSender(new DefaultBotOptions(), "7898004234:AAFupv2_MxnjzOZ9oDvyqqL8GMTg16Q7VUA");
    }
}
