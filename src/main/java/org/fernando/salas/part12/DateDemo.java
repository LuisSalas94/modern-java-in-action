package org.fernando.salas.part12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
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

        

    }
}
