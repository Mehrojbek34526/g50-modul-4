package uz.pdp.lesson7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 21/01/25 19:48
 **/
public class ObjectOutputAndInputStreamTest {

    public static void main(String[] args) {

        writeUsersToFile();

        readUsersFromFile();

    }

    @SuppressWarnings("unchecked")
    private static void readUsersFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("sd/users.txt"))) {

            List<User> users = (List<User>) objectInputStream.readObject();

            System.out.println(users);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeUsersToFile() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            users.add(new User(
                    i * 40L,
                    "username->" + i,
                    "FirstName-" + i,
                    "Lastname-" + i
            ));
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("sd/users.txt"));) {

            objectOutputStream.writeObject(users);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
