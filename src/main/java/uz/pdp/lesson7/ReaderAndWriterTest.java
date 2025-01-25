package uz.pdp.lesson7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;

/**
 Created by: Mehrojbek
 DateTime: 18/01/25 20:56
 **/
public class ReaderAndWriterTest {

    public static void main(String[] args) {

//        read();

//        write();

    }

    private static void write() {
        try (Writer writer = new FileWriter("io/writer.txt");) {

            writer.write("Hello World \nIts time: " + LocalDateTime.now());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void read() {
        try (
                Reader reader = new FileReader("io/doc.txt");
                Writer writer = new FileWriter("io/docCopy.txt");
        ) {

            reader.transferTo(writer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
