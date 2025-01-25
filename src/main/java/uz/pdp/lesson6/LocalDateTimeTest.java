package uz.pdp.lesson6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 21:01
 **/
public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

//        LocalDateTime localDateTime1 = now.plusDays(78);
        LocalDateTime localDateTime1 = now.plusHours(3780);
        System.out.println(localDateTime1);

        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();

        System.out.println(localDate);
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.of(2025, 1, 16, 19, 15,14,56987000);
        System.out.println(localDateTime);

    }

}
