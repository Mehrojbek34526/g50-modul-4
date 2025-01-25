package uz.pdp.lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 Created by: Mehrojbek
 DateTime: 18/01/25 20:51
 **/
public class DataInputOutputStreamTest {

    public static void main(String[] args) {

//        write();

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("io/data.txt"))){

            float v = dataInputStream.readFloat();
            System.out.println("v = " + v);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void write() {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("io/data.txt"))){

            dataOutputStream.writeFloat(97.85F);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
