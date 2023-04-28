import java.util.HashMap;
import java.util.List;


public class Year {
    private String fileName;
    public Year(String variable) {
        fileName = fileName;
    }

    HashMap<Integer, MonthInfo> myMap = new HashMap<>();
    Reader reader = new Reader();
    List<String> stringList = reader.readFileContents(fileName);
    String[] yearparts = fileName.split("\\.");
    String yearNum = yearparts[1];


    public void parsing() {

        System.out.println("Текущий год:\t" + yearNum );




        for (int i = 1; i < stringList.size(); i++) {
            String[] parts = stringList.get(i).split(",");

            Integer month = Integer.parseInt(parts[0]);
            int value = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            MonthInfo info = myMap.getOrDefault(month, new MonthInfo());
            if (isExpense) {
                info.expense += value;
            } else {
                info.income += value;
            }
            myMap.put(month, info);
        }


    }



    class MonthInfo {
    int income;
    int expense;


}}