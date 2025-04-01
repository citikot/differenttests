package online.agatstudio.timestamp_demo;

import java.time.LocalDate;
import java.time.ZoneId;

public class DateRangeExample {
    public static void main(String[] args) {
        // Задаём нужную дату, например, 27 апреля 2023
        LocalDate date = LocalDate.now();

        // Вычисляем начало дня (00:00:00) и переводим в Unix timestamp (в секундах)
        long startOfDay = date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000;

        // Вычисляем начало следующего дня, что соответствует концу текущего дня
        long endOfDay = date.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000;

        System.out.println("Start of day: " + startOfDay);
        System.out.println("End of day: " + endOfDay);
    }
}
