package online.agatstudio.date_time_demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter ruFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate java21release = LocalDate.parse("23.09.2023", ruFormat);

        System.out.println(java21release); // в ISO формате

        String formattedDate = java21release.format(ruFormat); // в заданном нами формате

        System.out.println(formattedDate);

        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy Q");

        formattedDate = java21release.format(outputFormat); // добавили в формат еще и квартал

        System.out.println(formattedDate);

    }
}
