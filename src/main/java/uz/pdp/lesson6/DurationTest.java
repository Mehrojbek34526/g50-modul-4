package uz.pdp.lesson6;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 21:51
 **/
public class DurationTest {

    public static void main(String[] args) {

//        LocalTime start = LocalTime.of(12, 45, 15);
//        LocalTime end = LocalTime.of(16, 30, 0);

        LocalDateTime start = LocalDateTime.now();
//        LocalDateTime end = start.plusMinutes(4900);
        LocalDateTime end = start.plusSeconds(49000);

        Duration duration = Duration.between(start, end);

        long seconds = duration.toSeconds();
        System.out.println(seconds);

        long hours = duration.toHours();
        System.out.println(hours);

        long days = duration.toDays();
        System.out.println(days);

        System.out.println(duration);

    }

}
