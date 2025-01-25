package uz.pdp.lesson5;

/**
 Created by: Mehrojbek
 DateTime: 12/01/25 12:58
 **/
public class SingletonTest {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        System.out.println(System.identityHashCode(singleton));

        Singleton singleton1 = Singleton.getInstance();
        System.out.println(System.identityHashCode(singleton1));


    }

}
