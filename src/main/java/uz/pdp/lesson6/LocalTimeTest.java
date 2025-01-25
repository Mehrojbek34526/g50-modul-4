package uz.pdp.lesson6;

import java.time.LocalTime;

/**
 Created by: Mehrojbek
 DateTime: 16/01/25 20:54
 **/
public class LocalTimeTest {

    public static void main(String[] args) {

        LocalTime localTimeNow = LocalTime.now();
        System.out.println(localTimeNow);

        LocalTime time = LocalTime.of(13, 44);

        //
        boolean after = time.isBefore(localTimeNow);
        System.out.println(after);

        System.out.println(time);

//        LocalTime localTime1 = localTimeNow.plusMinutes(57);
//        System.out.println(localTime1);



    }

}
