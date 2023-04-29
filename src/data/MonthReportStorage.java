package data;

import java.util.HashMap;
import java.util.List;

public class MonthReportStorage {

    private int ACTUAL_YEAR;
    private static final int MIN_MONTH_NUMBER = 1;
    private static final int MAX_MONTH_NUMBER = 3;
    private final HashMap<Integer, List<MonthReport>> months = new HashMap<>();

    public MonthReportStorage(int ACTUAL_YEAR) {
        this.ACTUAL_YEAR = ACTUAL_YEAR;
    }

    public void load( ) {
        for (int i = MIN_MONTH_NUMBER; i <= MAX_MONTH_NUMBER; i++) {

            String strNum;
            if (i < 10) {
                strNum = "0" + i;
            } else {
                strNum = Integer.toString(i);
            }
            String filename = "m." + ACTUAL_YEAR +  strNum + ".csv";

            months.put(i, MonthReportCsvDeserializer.deserialize("resources/" + filename));
        }

    }





    public HashMap<Integer, List<MonthReport>> getMonthsReport() {
        return months;

    }

}