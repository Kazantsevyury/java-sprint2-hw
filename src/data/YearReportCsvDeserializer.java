package data;


import java.util.ArrayList;
import java.util.List;

public class YearReportCsvDeserializer {
    /*
    public static List<YearReport> deserialize(String filename)
    {
        List<String> yearCsvEntries = CsvReader(filename);
        List<YearReport> yearReports = new ArrayList<>();
        for (int i =1; i<yearCsvEntries.size() ; i++ )
        {
            yearReports.add(deserializeEntry(yearCsvEntries.get(i)) );
        }
        return yearReports;
    }

    private static YearReport deserializeEntry(String csvLine )
    {
        String[] rawYearInfoFields = csvLine.split(",");

        YearReport yearReport = new YearReport();
        yearReport.monthNum = rawYearInfoFields[0];
        yearReport.amount= Integer.parseInt(rawYearInfoFields[1]);
        yearReport.isExpense= Boolean.parseBoolean(rawYearInfoFields[2]);

        return yearReport;

    } */
}
