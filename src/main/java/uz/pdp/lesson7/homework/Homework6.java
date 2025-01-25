package uz.pdp.lesson7.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 Created by: Mehrojbek
 DateTime: 21/01/25 19:08
 **/
public class Homework6 {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("homework/lug'at.txt"));) {

            Map<String, String> dictionary = new HashMap<>();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                //Ethic  —n. Set of moral principles (the quaker ethic). —adj. = *ethical. [greek: related to *ethos]
                //Ethical  adj. 1 relating to morals, esp. As concerning human conduct. 2 morally correct. 3 (of a drug etc.) Not advertised to the general public, and usu. Available only on prescription.  ethically adv.
                String key = null;
                String value = null;
                int endIndex = line.indexOf(" ");

                if (endIndex == -1) {
                    continue;
                }

                key = line.substring(0, endIndex);
                value = line.substring(endIndex + 1);

                dictionary.put(key, value);
            }

            System.out.println("Ethical-> " + dictionary.get("Ethical"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
