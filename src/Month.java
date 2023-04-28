import java.util.HashMap;
import java.util.List;

public class Month {
    HashMap<Integer, itemInfo > myMap = new HashMap<>();
    Reader reader = new Reader();

    public void parsing() {
        // тут цикл для отправки разных данных.
        String fileName = "resources/m.202101.csv" ;

        List<String> stringList = reader.readFileContents(fileName);
        String[] monthparts = fileName.split("\\.");
        String monthStr = monthparts[1];
        monthStr = monthStr.substring(4);
        Integer monthNum = Integer.parseInt(monthStr);


        for (int i = 1; i < stringList.size(); i++) { // Парсим приход

            String[] parts = stringList.get(i).split(",");

            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            Integer quantity = Integer.parseInt(parts[2]);
            Integer sumOfOne = Integer.parseInt(parts[3]);

            //int value
            itemInfo info = myMap.getOrDefault(monthNum, new itemInfo());
            if (isExpense) {
                info.expense -= quantity*sumOfOne;
            } else {
                info.income += quantity*sumOfOne;
            }
            myMap.put(monthNum, info);

        }

        System.out.println(myMap);
    }

    /*double getExpensesForMonth(String month) {
        itemInfo info = myMap.get(Integer.parseInt(month));
        if (info != null) {
            return info.income - info.expense;
        } else {
            return 0; // or throw an exception
        } */

}

class itemInfo {
    String itemName ;
    int income;
    int expense;
    int quantity;

    public String toString() {
        return "itemInfo{" +
                "income=" + income +
                ", expense=" + expense +
                '}';
    }
}