package uz.pdp.lesson7;

import java.io.File;

/**
 Created by: Mehrojbek
 DateTime: 18/01/25 19:08
 **/
public class FileTest {

    public static void main(String[] args) {

//        File file = new File("io/newDoc.txt");
//        File file = new File("io");

//        System.out.println(file.exists());
//
//        System.out.println(file.canExecute());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());


//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

//        if (file.exists()) {
//            file.delete();
//        }

//        String absolutePath = file.getAbsolutePath();
//        System.out.println(absolutePath);

//        System.out.println(file.getParent());
//
//        file = file.getAbsoluteFile();
//
//        System.out.println(file);

//        System.out.println(file.getParentFile().getParent());
//        System.out.println(file.getParentFile().getParentFile().getParent());

//        System.out.println(file.isAbsolute());

        File folder = new File("/Users/mehrojbekmavlonov/IdeaProjects/");

        searchingFile(folder,"ImtihonJavoblari.txt");

//        showAllInnerFiles(file);


    }

    private static void searchingFile(File folder, String fileName) {

        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {

                if (file.getName().equals(fileName)) {
                    System.out.println(file.getAbsolutePath());
                    return;
                }

                if (file.isDirectory()) {
                    searchingFile(file, fileName);
                }
            }
        }

    }

    public static void showAllInnerFiles(File file) {
        File[] files = file.listFiles();
        for (File oneFile : files) {
            System.out.println(oneFile);
            if (oneFile.isDirectory()) {
                showAllInnerFiles(oneFile);
            }
        }
    }

    //Vazifa:
    //ImtihonJavoblari.txt fayl
    //bor shu faylni butun bosh kompyuterdan qidirib topuvchi dastur yozilsin

}
