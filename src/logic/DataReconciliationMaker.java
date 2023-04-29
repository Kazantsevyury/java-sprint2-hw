package logic;

import data.MonthReport;
import data.MonthReportStorage;
import data.YearReportStorage;

import java.util.List;

public class DataReconciliationMaker {
    private final int ACTUAL_YEAR;

    private final MonthReportStorage monthReportStorage;
    private final YearReportStorage yearReportStorage;

    public DataReconciliationMaker(YearReportStorage yearReportStorage, MonthReportStorage monthReportStorage, int ACTUAL_YEAR) {
        this.monthReportStorage = monthReportStorage;
        this.yearReportStorage = yearReportStorage;
        this.ACTUAL_YEAR = ACTUAL_YEAR;
    }

    public void printDataReconciliation() {
        GetMonthsNamesRU nameRU = new GetMonthsNamesRU();
        System.out.println("Сравнение месячных и годовых отчетов за  "+  ACTUAL_YEAR + " год.");

        for (Integer month : monthReportStorage.getMonthsReport().keySet()) {
            List<MonthReport> monthlyReports = monthReportStorage.getMonthsReport().get(month);
            int sumIncomeInMonthReport = 0;
            int sumExpenseInMonthReport = 0;

            for (MonthReport report : monthlyReports) {
                if (!report.isExpense){
                    sumExpenseInMonthReport += (report.quantity *report.sumOfOne);
                } else {
                    sumIncomeInMonthReport += (report.quantity *report.sumOfOne);
                }

            }
            int incomeInYearReport = yearReportStorage.getMonthInYearReport().get(month).income;
            int expenseInYearReport = yearReportStorage.getMonthInYearReport().get(month).expense;

            if (!((sumExpenseInMonthReport == expenseInYearReport) && (sumIncomeInMonthReport == incomeInYearReport))) {
                System.out.println("Ошибка. Данныe в месяце: " + nameRU.getName(month)  + " не совпадают." );
            }
        }
        System.out.println("Cверка отчетов завершена.");
    }









}
