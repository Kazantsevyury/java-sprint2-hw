package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YearReportStorage
{
    private  final HashMap<Integer,YearReport> monthInYearReport = new HashMap<>();
    CsvReader reader = new CsvReader();
    private int ACTUAL_YEAR ;
    public  YearReportStorage(int ACTUAL_YEAR){
        this.ACTUAL_YEAR = ACTUAL_YEAR;
    }



    public void load() {
        List<String> rawYearInfoFields = reader.readFileContents("resources/y." + ACTUAL_YEAR + ".csv");

        for (int i = 1; i < rawYearInfoFields.size(); i++)
        {

            String[] parts = rawYearInfoFields.get(i).split(",");

            Integer month = Integer.parseInt(parts[0]);
            int value = Integer.parseInt(parts[1]);

            boolean isExpense = Boolean.parseBoolean(parts[2]);
            YearReport yearReport = monthInYearReport.getOrDefault(month, new YearReport());

            if (isExpense) {
                yearReport.income += value;
            } else {
                yearReport.expense += value;
            }
            yearReport.month = month;

            monthInYearReport.put(month, yearReport);

        }


    }

    public HashMap<Integer, YearReport> getMonthInYearReport() {
        return monthInYearReport;

    }



}
