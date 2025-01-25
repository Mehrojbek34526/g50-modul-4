package uz.pdp.lesson7;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 Created by: Mehrojbek
 DateTime: 18/01/25 20:46
 **/
public class InputAndOutputBufferedStream {

    public static void main(String[] args) {

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("io/doc.txt"));){

            while (bis.available() > 0) {
                System.out.print((char) bis.read());
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
