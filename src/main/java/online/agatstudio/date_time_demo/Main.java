package online.agatstudio.date_time_demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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

        LocalDate loanContractAt = LocalDate.of(2025, 1, 31);

        System.out.println("Дата заключения договора: " + loanContractAt);

        LocalDate firstPaymentAt = loanContractAt.plusMonths(1);

        System.out.println("Платеж: " + firstPaymentAt);

        LocalTime now = LocalTime.now();
        System.out.println(now);

//        LocalDateTime now = LocalDateTime.of(
//                2025, Month.FEBRUARY, 15, 10, 0);
        LocalDateTime nowLDT = LocalDateTime.now();
        LocalDate sputnikOneLaunchDate = LocalDate.of(1957, Month.OCTOBER, 4);
        LocalTime sputnikOneLaunchTime = LocalTime.of(22,28,34);
        LocalDateTime sputnikOneLaunchAt =
                LocalDateTime.of(sputnikOneLaunchDate, sputnikOneLaunchTime);

        // Разница в годах, месяцах и днях
        Period period =
                Period.between(sputnikOneLaunchAt.toLocalDate(), nowLDT.toLocalDate());
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.println("лет:" + years);
        System.out.println("месяцев:" + months);
        System.out.println("дней:" + days);

        withChronoUnits();
    }

    private static void withChronoUnits() {

        System.out.println("WithChronoUnits: ");

        // Текущее время
        LocalDateTime now = LocalDateTime.of(2025, Month.FEBRUARY, 15, 10, 0);

// Время запуска «Спутника-1»
        LocalDate sputnikOneLaunchDate = LocalDate.of(1957, Month.OCTOBER, 4);
        LocalTime sputnikOneLaunchTime = LocalTime.of(10, 28, 34);
        LocalDateTime sputnikOneLaunchAt = LocalDateTime.of(sputnikOneLaunchDate, sputnikOneLaunchTime);

// Вычисление разницы
        long years = ChronoUnit.YEARS.between(sputnikOneLaunchAt, now);
        LocalDateTime reducedDateTime = sputnikOneLaunchAt.plusYears(years);

        long months = ChronoUnit.MONTHS.between(reducedDateTime, now);
        reducedDateTime = reducedDateTime.plusMonths(months);

        long days = ChronoUnit.DAYS.between(reducedDateTime, now);
        reducedDateTime = reducedDateTime.plusDays(days);

        long hours = ChronoUnit.HOURS.between(reducedDateTime, now);
        reducedDateTime = reducedDateTime.plusHours(hours);

        long minutes = ChronoUnit.MINUTES.between(reducedDateTime, now);
        reducedDateTime = reducedDateTime.plusMinutes(minutes);

        long seconds = ChronoUnit.SECONDS.between(reducedDateTime, now);

// Вывод разницы
        System.out.println("года: " + years);
        System.out.println("месяцы: " + months);
        System.out.println("дни: " + days);
        System.out.println("часы: " + hours);
        System.out.println("минуты: " + minutes);
        System.out.println("секунд: " + seconds);
    }


}
