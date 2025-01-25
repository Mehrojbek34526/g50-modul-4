package uz.pdp.lesson6;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 21:07
 **/
public class ZonedDateTimeTest {

    public static void main(String[] args) {

        //1. Jamshid degan ishchi haftada 5 kun 6 soatdan va yakshanba kuni 8 soat ishlaydi
        //2021-03-16 sandan hozirgacha necha soat ishlagan
        //2. Olim ismni ishchi haftada 3 kun 7 soatdan ishlaydi lekin bahor va kuzda
        //haftasiga 5 kun 8 soatdan ishlasa jami 2022-01-01 dan hozirgacha necha soat ishlagan bo'ladi

        ZonedDateTime now = ZonedDateTime.now();
//        System.out.println(now);

        LocalDateTime localDateTimeNow = LocalDateTime.now();

        //hozir uzbekistonda 2025-01-16T17:12:48.957020+05:00[Asia/Tashkent] bolsa
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTimeNow, ZoneId.systemDefault());

//        ZoneId zone = ZoneId.of("Asia/Tokyo");
        ZoneId zone = ZoneId.of("Asia/Seoul");

        //bu Tokyoni
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(zone);

        System.out.println(zonedDateTime);

        System.out.println(zonedDateTime1);
    }

}
