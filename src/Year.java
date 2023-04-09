import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

 class Year {
     List<String> fileContents;

     public Year(List<String> fileContents) {
         this.fileContents = fileContents;
     }



     void process() {
         List<GoodsCirculation> goodsCirculations = new ArrayList<>();
         for (int i = 1; i < fileContents.size(); i++) {
             String line = fileContents.get(i);
             String[] fields = line.split(",");
             int monthNumber = Integer.parseInt(fields[0]);
             int amount = Integer.parseInt(fields[1]);
             boolean isExpense = Boolean.parseBoolean(fields[2]);

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
