import java.util.HashMap;
import java.util.Map;

public class YearStatistics {

    private Year year;

    public YearStatistics(Year year) {
        this.year = year;
    }
   /* double getExpensesForMonth(String month) {
        Year.MonthInfo info = myMap.get(month));
        if (info != null) {
            return info.income - info.expense;
        } else {
            return 0; // or throw an exception
        }
    }*/

    public void printStatistics() {

        System.out.println("Текущий год:\t" + year.yearNum);

        double totalIncome = 0;
        double totalExpense = 0;
        for (Map.Entry<Integer, Year.MonthInfo> entry : year.myMap.entrySet()) {
            int month = entry.getKey();
            Year.MonthInfo info = entry.getValue();
            double monthProfit = info.income - info.expense;
            System.out.printf("Месяц %d: прибыль = %.2f\n", month, monthProfit);
            totalIncome += info.income;
            totalExpense += info.expense;
        }

        double averageIncome = totalIncome / 12.0;
        double averageExpense = totalExpense / 12.0;

        System.out.printf("Средний доход за год = %.2f\n", averageIncome);
        System.out.printf("Средний расход за год = %.2f\n", averageExpense);
    }
}
