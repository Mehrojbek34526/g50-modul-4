package uz.pdp.lesson6;

import java.util.Date;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 19:11
 **/
public class DateTest {

    public static void main(String[] args) {

        Date date1 = new Date();
        System.out.println(date1);

        date1.setTime(date1.getTime() + 2 * 60 * 60 * 1000);
        System.out.println(date1);

//        date1.setTime(787687676564L);
//        System.out.println(date1);
//
//        Date date2 = new Date(System.currentTimeMillis());
//
//        //
//        boolean after = date1.after(date2);
//        System.out.println(after);
//        boolean before = date1.before(date2);
//        System.out.println(before);
//
//        long time = date1.getTime();
//        System.out.println(time);

//        //1970 1-yanvar 00:00 hozirgacha bo'lgan milli secondlar soni
//        Date date1 = new Date(0,0,0);
//        System.out.println(date1);
//
//        Date date2 = new Date(System.currentTimeMillis());
//        System.out.println(date2);

    }

}
