package task1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class CalendarPrinter {

    //Ответ на вопрос: 14 (7 дней недели + високосный/не високосный)

    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        boolean leap = isLeapYear(year);

        LocalDate firstDay = LocalDate.of(year, 1, 1);
        DayOfWeek dayOfWeek = firstDay.getDayOfWeek();

        int calendarType = dayOfWeek.getValue();
        if (leap) {
            calendarType += 7;
        }

        System.out.println("Год: " + year);
        System.out.println("Високосный: " + (leap ? "Да" : "Нет"));
        System.out.println("1 января выпадает на: " + dayOfWeek);
        System.out.println("Тип календаря (1–14): " + calendarType);
        System.out.println("--------------------------------------");

        for (int month = 1; month <= 12; month++) {
            printMonth(year, month);
        }
    }

    private static void printMonth(int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        LocalDate firstDayOfMonth = ym.atDay(1);
        DayOfWeek firstDow = firstDayOfMonth.getDayOfWeek();

        String monthName = ym.getMonth().toString();
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Пн Вт Ср Чт Пт Сб Вс");

        int indent = (firstDow.getValue() % 7);
        for (int i = 0; i < indent; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= ym.lengthOfMonth(); day++) {
            System.out.printf("%2d ", day);

            if ((day + indent) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
