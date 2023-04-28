package logic;

import data.YearReport;
import data.YearReportStorage;

import java.util.List;

public class YearReportMaker {
    GetMonthsNamesRU getMonthsNamesRU = new GetMonthsNamesRU();
    private final YearReportStorage yearReportStorage;

    public YearReportMaker(YearReportStorage yearReportStorage){
        this.yearReportStorage = yearReportStorage;
    }


    public void printMonthInYearReport() {
        System.out.println("Рассматриваемый год: "+yearReportStorage.getYearNum() );
        System.out.println("---------------");
        //YearReport yearReport = yearReportStorage.getMonthInYearReport().get(1);
        int medianExpense = 0;
        int medianIncome = 0;
        int lastMonat = 1;
        for (Integer month : yearReportStorage.getMonthInYearReport().keySet()) {
           // YearReport yearReport = monthInYearReport.get(month);
            System.out.println("Месяц:\t\t\t" + getMonthsNamesRU.getName(month));
            YearReport yearReport = yearReportStorage.getMonthInYearReport().get(month);
            System.out.println("Прибыль:\t\t" + (yearReport.expense - yearReport.income) );
            medianExpense += yearReport.expense;
            medianIncome  += yearReport.income;
            if (lastMonat< month){
                lastMonat = month;
            }

        }
        System.out.println("---------------");
        System.out.println("Средний расход:\t" +medianExpense/lastMonat );
        System.out.println("Средний доход:\t" +medianIncome/lastMonat);
        System.out.println("---------------");
    }

/*
    public String bildUserMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        List<YearReport> months = yearReportStorage.getAllMonth();
        for (YearReport yearReport:months ){
            stringBuilder.append(months.month).append("\n");
        }

        return stringBuilder.toString();

    }
*/


}
