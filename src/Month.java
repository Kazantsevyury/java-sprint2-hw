import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Month {
    String name ;
    HashMap<String, ArrayList<Integer>> myMap = new HashMap<>();
    public Month(String name) {
        this.name = name;
    }

    public void parsing(String filename) {
        Reader reader = new Reader();
        List<String> stringList = reader.readFileContents(filename);

        for (int i = 1; i < stringList.size(); i++) {
            String[] parts = stringList.get(i).split(",");

            String key = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            int price = Integer.parseInt(parts[3]);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(quantity);
            if (isExpense) {
                list.add(-price);
            }
            else {
                list.add(price);
            }
            myMap.put(key, list);

        }


        System.out.println(myMap);

    }

}
