package logic;
import data.MonthReport;
import data.MonthReportStorage;
import data.YearReportStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        System.out.println("Сравнение месячных и годовых отчетов за " + ACTUAL_YEAR + " год.");

        for (Node node : getNodeList()) {
            int sumIncomeInMonthReport = 0;
            int sumExpenseInMonthReport = 0;

// Не уверен что я правильно понял, что мне надо было сделать.

            for (MonthReport report : node.getValue()) {
                if (!report.isExpense) {
                    sumExpenseInMonthReport += (report.quantity * report.sumOfOne);
                } else {
                    sumIncomeInMonthReport += (report.quantity * report.sumOfOne);
                }
            }

            int incomeInYearReport = yearReportStorage.getMonthInYearReport().get(node.getKey()).income;
            int expenseInYearReport = yearReportStorage.getMonthInYearReport().get(node.getKey()).expense;

            if (!((sumExpenseInMonthReport == expenseInYearReport) && (sumIncomeInMonthReport == incomeInYearReport))) {
                System.out.println("Ошибка. Данные в месяце: " + nameRU.getName(node.getKey()) + " не совпадают.");
            }
        }
        System.out.println("Cверка отчетов завершена.");
    }

    private List<Node> getNodeList() {
        Map<Integer, List<MonthReport>> map = monthReportStorage.getMonthsReport();
        List<Node> nodeList = new ArrayList<>();

        for (Map.Entry<Integer, List<MonthReport>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<MonthReport> value = entry.getValue();

            Node node = new Node(key, value);
            nodeList.add(node);
        }

        return nodeList;
    }

    private static class Node {
        private final Integer key;
        private final List<MonthReport> value;
        public Node(Integer key, List<MonthReport> value) {
            this.key = key;
            this.value = value;
        }
        public Integer getKey() {
            return key;
        }

        public List<MonthReport> getValue() {
            return value;
        }

    }
}
