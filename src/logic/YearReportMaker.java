package logic;

import data.YearReport;
import data.YearReportStorage;

public class YearReportMaker {
    private final int ACTUAL_YEAR;
    GetMonthsNamesRU getMonthsNamesRU = new GetMonthsNamesRU();
    private final YearReportStorage yearReportStorage;

    public YearReportMaker(YearReportStorage yearReportStorage, int ACTUAL_YEAR){
        this.ACTUAL_YEAR = ACTUAL_YEAR;
        this.yearReportStorage = yearReportStorage;
    }

    public void printMonthInYearReport() {
        System.out.println("Рассматриваемый год: "+ ACTUAL_YEAR );
        System.out.println("----------------------------");
        int medianExpense = 0;
        int medianIncome = 0;
        int lastMonat = 1;
        for (Integer month : yearReportStorage.getMonthInYearReport().keySet()) {
            System.out.println("Месяц:\t\t\t" + getMonthsNamesRU.getName(month));
            YearReport yearReport = yearReportStorage.getMonthInYearReport().get(month);
            System.out.println("Прибыль:\t\t" + (yearReport.expense - yearReport.income) );
            medianExpense += yearReport.expense;
            medianIncome  += yearReport.income;
            if (lastMonat< month){
                lastMonat = month;
            }
        }
        System.out.println("----------------------------");
        System.out.println("Средний расход:\t" +medianExpense/lastMonat );
        System.out.println("Средний доход:\t" +medianIncome/lastMonat);
        System.out.println("----------------------------");
    }
}
