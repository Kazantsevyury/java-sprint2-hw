package logic;

import data.MonthReportStorage;

public class MonthReportLoader {
    private int ACTUAL_YEAR;


    private final MonthReportStorage monthReportStorage;

    public MonthReportLoader (MonthReportStorage monthReportStorage, int ACTUAL_YEAR) {
        this.monthReportStorage = monthReportStorage;
        this.ACTUAL_YEAR = ACTUAL_YEAR;
    }

    public void load() {
        System.out.println("Read");
        monthReportStorage.load();
    }

}