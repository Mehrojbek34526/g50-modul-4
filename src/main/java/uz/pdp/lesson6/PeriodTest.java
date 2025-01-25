package uz.pdp.lesson6;

import java.time.LocalDate;
import java.time.Period;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 21:57
 **/
public class PeriodTest {

    public static void main(String[] args) {

        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusDays(1450);

        Period period = Period.between(start, end);
        System.out.println(period);

        int days = period.getDays();
        System.out.println(days);

        int months = period.getMonths();
        System.out.println(months);

    }

}
