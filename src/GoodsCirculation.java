 class GoodsCirculation {

private int monthNumber;
private int income;
private int expenses;A

public GoodsCirculation(int monthNumber, int income, int expenses) {
        this.monthNumber = monthNumber;
        this.income = income;
        this.expenses = -expenses;
        }
         public int getMonthNumber() {
                 return monthNumber;
         }

         public void addIncome(int amount) {
                 this.income += amount;
         }

         public void addExpenses(int amount) {
                 this.expenses += amount;
         }


         public String toString() {
        return "Month: " + monthNumber + ", Income: " + income + ", Expenses: " + expenses;
        }
        }