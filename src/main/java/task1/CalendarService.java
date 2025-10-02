package task1;

import java.time.LocalDate;
import java.time.YearMonth;

public class CalendarService {

    private static final String[] MONTHS = {
            "Январь", "Февраль", "Март", "Апрель",
            "Май", "Июнь", "Июль", "Август",
            "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
    };

    public void printYear(int year) {

        for (int month = 1; month <= 12; month++) {
            printMonth(year, month);
        }
    }

    private void printMonth(int year, int month) {
        YearMonth ym = YearMonth.of(year, month);
        LocalDate firstDayOfMonth = ym.atDay(1);
        int firstDow = firstDayOfMonth.getDayOfWeek().getValue();

        String monthName = MONTHS[month - 1];
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Пн Вт Ср Чт Пт Сб Вс");

        int indent = firstDow - 1;
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
