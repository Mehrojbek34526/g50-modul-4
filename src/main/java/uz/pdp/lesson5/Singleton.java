package uz.pdp.lesson5;

/**
 Created by: Mehrojbek
 DateTime: 12/01/25 12:57
 **/
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    //ishlaydigan usul
    public static Singleton getInstance() {
        if (instance == null) {
            //
            //2-thread
            synchronized (Singleton.class) {
                //faqat bitta thread 1-thread
                if (instance == null) {
                    instance = new Singleton();
                }
                //
            }
        }
        return instance;
    }


}
