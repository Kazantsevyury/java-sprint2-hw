import java.util.*;

public class Year {


    HashMap<String, ArrayList<Integer>> myMap = new HashMap<>();
    Reader reader = new Reader();
    public void parsing() {
        List<String> stringList = reader.readFileContents("resources/y.2021.csv");

        for (int i = 1; i < stringList.size(); i++) { // Парсим приход
            String[] parts = stringList.get(i).split(",");

            String key = parts[0];
            int value = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            if (!(isExpense)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(value);
                myMap.put(key, list);
            }
        }

        for (int i = 1; i < stringList.size(); i++) { // Парсим расход
            String[] parts = stringList.get(i).split(",");

            String key = parts[0];
            int value = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            if (isExpense) {
                ArrayList<Integer> list = myMap.get(key);
                list.add(-value);
                myMap.put(key, list);
            }
        }
        System.out.println(myMap);

    }

    public void getSum() {
        HashMap<String, Integer> sums = new HashMap<>();

        for (String key : myMap.keySet()) {
            int sum = 0;
            for (int val : myMap.get(key)) {
                sum += val;
            }
            sums.put(key, sum);
        }


        System.out.println(sums);
    }


}
