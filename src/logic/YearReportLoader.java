package logic;

import data.YearReportStorage;

public class YearReportLoader {
    private int ACTUAL_YEAR ;


    private final   YearReportStorage yearReportStorage;

    public YearReportLoader(YearReportStorage yearReportStorage, int ACTUAL_YEAR){
        this.yearReportStorage = yearReportStorage;
        this.ACTUAL_YEAR =ACTUAL_YEAR;
    }

    public void load( ){
        System.out.println("Read");
        yearReportStorage.load();
    }
}
