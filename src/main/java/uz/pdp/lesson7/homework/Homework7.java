package uz.pdp.lesson7.homework;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 Created by: Mehrojbek
 DateTime: 21/01/25 19:24
 **/
public class Homework7 {

    public static void main(String[] args) {

        int year = 2020;

        try {

            //2020
            Path yearPath = Path.of(String.valueOf(year));
            Files.createDirectory(yearPath);

            for (Month month : Month.values()) {

                //2020/JANUARY
                Path monthPath = yearPath.resolve(month.name());
                Files.createDirectory(monthPath);

                LocalDate start = LocalDate.of(year, month, 1);

                //2020-01
                YearMonth yearMonth = YearMonth.of(year, month);

                //2020-01-31
                LocalDate end = yearMonth.atEndOfMonth();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

                while (start.isBefore(end) || start.equals(end)) {

                    String folderName = formatter.format(start) + ".txt";

                    //2020/JANUARY/01.01.2020.txt
                    Path dayPath = monthPath.resolve(folderName);

                    try (Writer writer = new FileWriter(dayPath.toFile())) {
                        writer.write(LocalDateTime.now().toString());
                    }

                    start = start.plusDays(1);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
