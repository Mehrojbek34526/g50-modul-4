package uz.pdp.lesson7;

import java.io.*;

/**
 Created by: Mehrojbek
 DateTime: 18/01/25 20:29
 **/
public class InputAndOutputStreamTest {

    public static void main(String[] args) {

//        inputStream();

//        outputStream();

    }

    private static void outputStream() {
        String path = "io/doc.txt";

        try (OutputStream outputStream = new FileOutputStream(path,false)){

            String str = "\nHello world";

            byte[] bytes = str.getBytes();

            outputStream.write(bytes);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void inputStream() {
        File file = new File("io/doc.txt");

        try (InputStream inputStream = new FileInputStream(file)) {

            byte[] bytes = inputStream.readAllBytes();

            String string = new String(bytes);
            System.out.println(string);

//            int read = inputStream.read();
//            System.out.println((char) read);
//
//            System.out.println((char) inputStream.read());
//            System.out.println((char) inputStream.read());
//            System.out.println((char) inputStream.read());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
