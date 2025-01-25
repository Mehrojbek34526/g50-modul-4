package uz.pdp.lesson6;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 19:24
 **/
public class CalendarTest {

    public static void main(String[] args) {

        int dayOfWeekNum = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeekNum);

//        Calendar calendar = new GregorianCalendar();
        Calendar start = Calendar.getInstance();

        System.out.println(start.get(Calendar.DAY_OF_MONTH));
        System.out.println(start.get(Calendar.WEEK_OF_MONTH));

        start.set(2018,0,1, 0,0);

        Date date = start.getTime();
        System.out.println(date);

        Calendar currentCalendar = Calendar.getInstance();//hozirgi vaqt

        //dushanba-juma
        //2-6
        int workingDays = 0;
        while (start.before(currentCalendar)) {

            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);

            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                workingDays++;
            }

            start.add(Calendar.DATE, 1);
        }

        System.out.println(workingDays);

        //John degan ishchi 2018-01-01 hozirgi kungacha agar
        //besh kunlik ish kunida ishlasa necha ish kuni ishlagan

//        calendar.add(Calendar.HOUR, 2);


//        System.out.println(calendar);

//        Date oldDate = calendar.getTime();
//        System.out.println(oldDate);
//
//


//        Date date = calendar.getTime();
//        System.out.println(date);

//        int firstDayOfWeek = calendar.getMinimalDaysInFirstWeek();
//        System.out.println(firstDayOfWeek);

//        int weekYear = calendar.getWeekYear();
//        System.out.println(weekYear);

    }

}
