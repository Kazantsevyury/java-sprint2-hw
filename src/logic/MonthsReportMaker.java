package logic;
import data.MonthReport;
import data.MonthReportStorage;

import java.util.List;
import java.util.ArrayList;

public class MonthsReportMaker {
    private int ACTUAL_YEAR;

    private final MonthReportStorage monthReportStorage;

    public MonthsReportMaker(MonthReportStorage monthReportStorage, int ACTUAL_YEAR) {
        this.monthReportStorage = monthReportStorage;
        this.ACTUAL_YEAR = ACTUAL_YEAR;
    }


    public void printMonthReport() {
        System.out.println("Рассматриваемый год: "+  ACTUAL_YEAR);
        System.out.println("----------------------------");
        int mostProfitableProduct = 0;
        String mostProfitableProductName = "" ;
        int theBiggestExpense = 0;
        String theBiggestExpenseName= "" ;
        GetMonthsNamesRU nameRU = new GetMonthsNamesRU();
        for (Integer month : monthReportStorage.getMonthsReport().keySet()) {
            List<MonthReport> monthlyReports = new ArrayList<>();
            monthlyReports = monthReportStorage.getMonthsReport().get(month);
           MonthReport monthReport = new MonthReport();
            System.out.println("Месяц:\t\t\t" + nameRU.getName(month) );
            for (int i = 0; i < monthlyReports.size(); i++) {
                monthReport = monthlyReports.get(i);


            if (!monthReport.isExpense){
                if ((monthReport.quantity * monthReport.sumOfOne)>mostProfitableProduct){
                    theBiggestExpense = monthReport.quantity * monthReport.sumOfOne;
                    mostProfitableProductName = monthReport.itemName;
                }
            } else {
                if ((monthReport.quantity * monthReport.sumOfOne)>theBiggestExpense){
                    theBiggestExpense=(monthReport.quantity * monthReport.sumOfOne);
                    theBiggestExpenseName = monthReport.itemName;

                }
            }
            }
            System.out.println("----------------------------");
            System.out.println("Самый прибыльный товар:\t"+ mostProfitableProductName + "\t"+ mostProfitableProduct  );

            System.out.println("Самая большая трата:\t"+ theBiggestExpenseName+ "\t"+ theBiggestExpense );
            System.out.println("----------------------------");
        }



    }

    }






