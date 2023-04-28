package logic;

import data.YearReportStorage;

public class YearReportLoader {


    private final   YearReportStorage yearReportStorage;

    public YearReportLoader(YearReportStorage yearReportStorage){
        this.yearReportStorage = yearReportStorage;
    }

    public void load(int ACTUAL_YEAR ){
        System.out.println("Read");
        yearReportStorage.load(ACTUAL_YEAR);
    }
}
