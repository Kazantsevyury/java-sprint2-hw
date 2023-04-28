package logic;

public class GetMonthsNamesRU {
    private static final String[] MONTHS_NAMES = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    String getName(int monthNumber) {
        if (monthNumber >= 1 && monthNumber <= 12) {
            return MONTHS_NAMES[monthNumber - 1];
        } else {
            throw new IllegalArgumentException("Некорректный номер месяца: " + monthNumber);
        }
    }
}

