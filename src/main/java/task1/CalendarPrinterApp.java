package task1;

import java.util.Scanner;

public class CalendarPrinterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalendarService service = new CalendarService();

        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        service.printYear(year);
    }
}
