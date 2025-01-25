package uz.pdp.lesson6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 20:47
 **/
public class LocalDateTest {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDate localDate1 = localDate.plusDays(19);
        System.out.println(localDate1);

        LocalDate localDate2 = localDate.minusMonths(3);
        System.out.println(localDate2);

        boolean leapYear = localDate2.isLeapYear();
        System.out.println(leapYear);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        Month month = localDate2.getMonth();

        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println(dayOfMonth);

        System.out.println(month);

        if (dayOfWeek == DayOfWeek.THURSDAY) {
            System.out.println("Thursday");
        }

    }

}
