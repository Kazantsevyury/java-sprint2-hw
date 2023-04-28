package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YearReportStorage
{
    private  final HashMap<Integer,YearReport> monthInYearReport = new HashMap<>();
    CsvReader reader = new CsvReader();



    public void load(int ACTUAL_YEAR) {
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
            yearReport.ACTUAL_YEAR=ACTUAL_YEAR;

            monthInYearReport.put(month, yearReport);

        }

        //return monthInYearReport;

    }
    /*public List<YearReport> getAllMonth() {
        List<YearReport> result = new ArrayList<>();
        for (Integer month : monthInYearReport.keySet()) {
            YearReport yearReport = monthInYearReport.get(month);
            result.add(yearReport);
        }
        return result;
    }*/
    public HashMap<Integer, YearReport> getMonthInYearReport() {
        return monthInYearReport;

    }
    public int getYearNum() {
        return monthInYearReport.get(1).ACTUAL_YEAR;

    }

    /*
    public List<YearReport> getAllMonth(){
        List<YearReport> result =new ArrayList<>();
        for (Integer month : monthInYearReport.keySet()) {
            result.addAll(month);
        }
        return result;



    }
*/
}
