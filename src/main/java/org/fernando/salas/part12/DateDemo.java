package org.fernando.salas.part12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        // Date date = new Date(117, 8, 21);
        // Thu Sep 21 00:00:00 PET 2017
        // System.out.println(date);
        LocalDate date = LocalDate.of(2024, 8, 1);
        // Date: 2024-08-01
        System.out.println("Date: " + date);

        int year = date.getYear();
        // Year: 2024
        System.out.println("Year: " + year);

        Month month = date.getMonth();
        // Month: AUGUST
        System.out.println("Month: " + month);

        DayOfWeek day = date.getDayOfWeek();
        // Day: THURSDAY
        System.out.println("Day: " + day);

        int len = date.lengthOfMonth();
        // Len: 31
        System.out.println("Len: " + len);

        boolean leap = date.isLeapYear();
        // Leap: true
        System.out.println("Leap: " + leap);

        LocalDate today = LocalDate.now();
        // Now: 2024-08-01
        System.out.println("Now: " + today);

        int chronosField = date.get(ChronoField.YEAR);
        // 2024
        System.out.println("ChronosField: " + chronosField);

        int chronosMonth = date.get(ChronoField.MONTH_OF_YEAR);
        // 8
        System.out.println("ChronosMonth: " + chronosMonth);

        int chronosDay = date.get(ChronoField.DAY_OF_MONTH);
        // 1
        System.out.println("ChronosDay: " + chronosDay);

        // Creating a LocalTime and reading its values
        LocalTime time = LocalTime.of(13, 45, 20);
        // 13:45:20
        System.out.println("Time: " + time);

        int hour = time.getHour();
        System.out.println("hour: " + hour);

        int minute = time.getMinute();
        System.out.println("minute: " + minute);

        int second = time.getSecond();
        System.out.println("second: " + second);

        // Creating a LocalDateTime directly or by combining a date and a time
        LocalDateTime dt1 = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
        System.out.println("dt1: " + dt1);

        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println("dt2: " + dt2);

        LocalDateTime dt3 = date.atTime(12, 45, 20);
        System.out.println("dt3: " + dt3);

        LocalDateTime dt4 = date.atTime(time);
        System.out.println("dt4: " + dt4);

        LocalDateTime dt5 = time.atDate(date);
        System.out.println("dt5: " + dt5);


        Period tenDays = Period.between(LocalDate.of(2017, 9, 11),
                LocalDate.of(2017, 9, 21));
        // P10D
        System.out.println("tenDays: " + tenDays);

        // Creating Durations and Periods
        Duration threeMinutes = Duration.ofMinutes(3);
        // PT3M
        System.out.println("threeMinutes: " + threeMinutes);

        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
        // PT3M
        System.out.println("threeMinutes2: " + threeMinutes2);

        Period tenDays2 = Period.ofDays(10);
        // P10D
        System.out.println("tenDays2: " + tenDays2);

        Period threeWeeks = Period.ofWeeks(3);
        // P21D
        System.out.println("threeWeeks: " + threeWeeks);

        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        // P2Y6M1D
        System.out.println("twoYearsSixMonthsOneDay: " + twoYearsSixMonthsOneDay);
    }
}
