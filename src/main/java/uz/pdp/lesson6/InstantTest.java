package uz.pdp.lesson6;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 20:33
 **/
public class InstantTest {

    public static void main(String[] args) {

        Instant nowInstantUzb = Instant.now().plus(5, ChronoUnit.HOURS);
        Instant instant1 = Instant.now().minus(5, ChronoUnit.HOURS);

        boolean before = instant1.isBefore(nowInstantUzb);
        System.out.println(before);

        boolean after = instant1.isAfter(nowInstantUzb);
        System.out.println(after);

        Instant instant2 = nowInstantUzb.plusSeconds(3600);
        System.out.println(instant2);

//        Instant newInstant = instant.plus(5, ChronoUnit.HOURS);

        System.out.println(nowInstantUzb);
        System.out.println(instant1);

//        System.out.println(newInstant);

    }

}
