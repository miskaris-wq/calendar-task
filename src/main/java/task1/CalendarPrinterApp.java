package task1;

import java.util.Scanner;

// Ответ на вопрос: 14 (7 дней недели + високосный/не високосный год)

public class CalendarPrinterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalendarService service = new CalendarService();

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        service.printYear(year);
    }
}
