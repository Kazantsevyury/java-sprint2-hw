package logic;
import data.MonthReport;
import data.MonthReportStorage;
import java.util.List;

public class MonthsReportMaker {
    private final int ACTUAL_YEAR;
    private final MonthReportStorage monthReportStorage;
    public MonthsReportMaker(MonthReportStorage monthReportStorage, int ACTUAL_YEAR) {
        this.monthReportStorage = monthReportStorage;
        this.ACTUAL_YEAR = ACTUAL_YEAR;
    }


    public void printMonthReport() {
        System.out.println("Рассматриваемый год: "+  ACTUAL_YEAR);
        System.out.println("--------------------------------------------------------");

        GetMonthsNamesRU nameRU = new GetMonthsNamesRU();
        for (Integer month : monthReportStorage.getMonthsReport().keySet()) {
            System.out.println("Месяц:\t\t\t" + nameRU.getName(month));

            List<MonthReport> monthlyReports = monthReportStorage.getMonthsReport().get(month);
            int mostProfitableProduct = 0;
            String mostProfitableProductName = "";
            int theBiggestExpense = 0;
            String theBiggestExpenseName = "";
            for (MonthReport report : monthlyReports) {

                if (!report.isExpense){
                    if ((report.quantity * report.sumOfOne) > mostProfitableProduct){
                        mostProfitableProduct = report.quantity * report.sumOfOne;
                        mostProfitableProductName = report.itemName;
                    }
                } else {
                    if ((report.quantity * report.sumOfOne) > theBiggestExpense){
                        theBiggestExpense = report.quantity * report.sumOfOne;
                        theBiggestExpenseName = report.itemName;
                    }
                }
            }

            System.out.println("Самый прибыльный товар:\t" + mostProfitableProductName + "\t" + mostProfitableProduct);
            System.out.println("Самая большая трата:\t" + theBiggestExpenseName + "\t" + theBiggestExpense);
            System.out.println("--------------------------------------------------------");
        }
    }

}




