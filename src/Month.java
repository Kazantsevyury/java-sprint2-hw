import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

class Month {
    List<String> fileContents;

    public Month(List<String> fileContents) {
        this.fileContents = fileContents;
    }



    void process() {
        List<GoodsCirculation> goodsCirculations = new ArrayList<>();
        for (int i = 1; i < fileContents.size(); i++) {
            String line = fileContents.get(i);
            String[] fields = line.split(",");

            String itemName = String.parseInt(fields[0]);
            boolean isExpense = Boolean.parseBoolean(fields[1]);
            int quantity = Integer.parseInt(fields[2]);
            int sumOfOne = Integer.parseInt(fields[3]);

            GoodsCirculation goodsCirculation = null;
            for (GoodsCirculation gc : goodsCirculations) {
                if (gc.getMonthNumber() == monthNumber) {
                    goodsCirculation = gc;
                    break;
                }
            }

            if (goodsCirculation == null) {
                if (isExpense) {
                    goodsCirculation = new GoodsCirculation(monthNumber, 0, amount);
                } else {
                    goodsCirculation = new GoodsCirculation(monthNumber, amount, 0);
                }
                goodsCirculations.add(goodsCirculation);
            } else {
                if (isExpense) {
                    goodsCirculation.addExpenses(amount);
                } else {
                    goodsCirculation.addIncome(amount);
                }
            }
        }
        for (GoodsCirculation gc : goodsCirculations) {
            System.out.println(gc);
        }
    }
}
















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
