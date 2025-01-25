package uz.pdp.lesson7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 Created by: Mehrojbek
 DateTime: 18/01/25 21:18
 **/
public class PathTest {

    public static void main(String[] args) {

        Path path = Paths.get("io", "f1", "f2", "doc2.txt");

        path = path.toAbsolutePath();

//        System.out.println(path);

//        System.out.println("path.getFileName() = " + path.getFileName());
//
//        System.out.println(path);
//
//        Path parent = path.getParent();
//        System.out.println("parent = " + parent);
//
//        System.out.println(parent.getParent());

//        Path root = path.getRoot();
//        System.out.println(root);

//        System.out.println(path);
//
//        path = path.resolve("doc2.txt");
//
//        System.out.println(path);

        try {
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        copy();

        //1. Birorta java classni ichini inputStream bilan o'qib java.txt faylga out bilan yozish
        //2. Yuqorida yozilgan faylni buffered reader orqali qatorma-qator qator raqami bilan ekranga chiqarish va
        //qatorma-qator boshqa buffered.txt faylga yozish
        //3. Files classi bilan bir faylni boshqa papkaga kopiya olish

    }

    private static void copy() {
        Path source = Paths.get("io/f1/f2/doc2.txt");
        Path target = Paths.get("io/f1/copydoc2.txt");

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
