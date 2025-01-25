package uz.pdp.lesson8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Created by: Mehrojbek
 DateTime: 21/01/25 21:01
 **/
public class RegexTest {

    public static void main(String[] args) {

//        numberCheck();

//        phoneCheck();

//        replaceAll();

        //1. Berilgan textda faqat alfavitdagi katta-kichik harflarni qoldiradigan kod yozing
        //2. Berilgan textda faqat raqamlarni qoldiradigan kod yozing
        //3. Raqam va belgidan iborat textni qoldigan kod yozing
        //4. Faqat bo'shliqlar qoldiradigan kod yozish

    }

    private static void replaceAll() {
        Pattern pattern = Pattern.compile("\\d");

        String str = "abc68%6**&gyytHGFD9hgvg78";
        Matcher matcher = pattern.matcher(str);

        StringBuilder numbers = new StringBuilder();
        while (matcher.find()) {
            numbers.append(matcher.group());
        }

        System.out.println(numbers.toString());

        String numbers1 = str.replaceAll("\\D", "");
        System.out.println(numbers1);
    }

    private static void phoneCheck() {
        Pattern pattern = Pattern.compile("^\\+998[0-9]{9}$");

        Matcher matcher = pattern.matcher("+998111234567");

        if (!matcher.find()) {
            throw new RuntimeException("Invalid phone number");
        } else {
            System.out.println(matcher.group());
        }
    }

    private static void numberCheck() {
        Pattern pattern = Pattern.compile("\\d");

        Matcher matcher = pattern.matcher("abc68%6**&gyytHGFD9");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
