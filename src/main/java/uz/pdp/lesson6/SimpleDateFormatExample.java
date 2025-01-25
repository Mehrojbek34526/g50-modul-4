package uz.pdp.lesson6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 19:54
 **/
public class SimpleDateFormatExample {

    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss S w W D");

        DateFormat timeInstance = SimpleDateFormat.getTimeInstance();
        DateFormat dateFormat = SimpleDateFormat.getDateInstance();

        Date date = new Date();

        String format = simpleDateFormat.format(date);
        String format1 = timeInstance.format(date);
        String format2 = dateFormat.format(date);

        System.out.println(format);
        System.out.println(format1);
        System.out.println(format2);

    }

}
