package uz.pdp.lesson7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 Created by: Mehrojbek
 DateTime: 18/01/25 21:06
 **/
public class BufferedReaderAndWriterTest {

    public static void main(String[] args) {

//        write();

//        read();

    }

    private static void write() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("io/bufWriter.txt"))) {

            bufferedWriter.write("Bu test uchun yaratildi\n");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void read() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("io/doc.txt"))) {

//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//            System.out.println(bufferedReader.readLine());
//
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }

            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
