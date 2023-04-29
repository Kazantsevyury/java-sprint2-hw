package data;
import java.util.ArrayList;

import java.util.List;

public class MonthReportCsvDeserializer {

    public static List<MonthReport> deserialize(String filename) {
        CsvReader reader = new CsvReader();

        List<String> monthReportCsvEntries = reader.readFileContents(filename);
        List<MonthReport> monthReports = new ArrayList<>();
        for (int i = 1; i < monthReportCsvEntries.size(); i++) {
            monthReports.add(deserializeEntry(monthReportCsvEntries.get(i)));
        }
        return monthReports;
    }

    public static MonthReport deserializeEntry(String playerCsvEntry) {
        String[] rawMonthReportFields = playerCsvEntry.split(",");
        MonthReport monthReport = new MonthReport();
        monthReport.itemName = rawMonthReportFields[0];
        monthReport.isExpense = Boolean.parseBoolean(rawMonthReportFields[1]);
        monthReport.sumOfOne = Integer.parseInt(rawMonthReportFields[2]);
        monthReport.quantity = Integer.parseInt(rawMonthReportFields[3]);

        return monthReport;
    }



}
