import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        boolean exitFlag = false ;
        boolean isYearRepUp = false;
        boolean isMonthlyRepUp = false;


        while (!exitFlag){
            printMenu();
            String command = scanner.nextLine();

            if (command.equals("root")) {
                System.out.println("Выход из программы...");
                exitFlag = true;



               /* for (int i = 1; i <= 3; i++) {

                    String string = String.format("%02d", i);
                    Month month = new Month(string);
                    month.parsing("resources/m.2021" + string + ".csv");
                    isMonthlyRepUp = true;
                }*/



            } else if (command.equals('2')  ) {
                Year year = new Year();
                year.parsing();
                System.out.println(year.toString());
                isYearRepUp = true;

            }/* else if (command.equals('3') ) {

                if (isYearRepUp && isMonthlyRepUp ){
                    Comparison comparison = new Comparison();

                    Year year2021 = new Year();
                    year2021.parsing(); ;

                    String monthNumber = "01";

                    Month month = new Month(monthNumber);
                    month.parsing("resources/m.2021" + monthNumber + ".csv");


                    Integer yearExpenses = year2021.getExpensesForMonth(monthNumber); // получаем сумму расходов за месяц из годового отчета
                    Integer monthExpenses = month.getExpenses(monthNumber); // получаем сумму расходов за месяц из месячного отчета
                    Integer result = comparison.compare(yearExpenses, monthExpenses); // сравниваем суммы расходов
                    if (result == 0) {
                        System.out.println("Сумма расходов за месяц " + monthNumber + " совпадает в годовом и месячном отчетах.");
                    } else if (result > 0) {
                        System.out.println("Сумма расходов за месяц " + monthNumber + " в годовом отчете больше, чем в месячном.");
                    } else {
                        System.out.println("Сумма расходов за месяц " + monthNumber + " в месячном отчете больше, чем в годовом.");
                    }
                }
                else {
                    System.out.println("Невозможно выполнить команду. Считайте месячный и годовой отчеты." );
                }

            }else if (command.equals('4')  ) {
                if ( isMonthlyRepUp ){
                  //  Comparison comparison = new Comparison();
                }
                else {
                    System.out.println("Невозможно выполнить команду. Считайте месячные отчеты." );
                }

            }else if (command.equals('5')  ) {
                if (isYearRepUp  ){
                    //Comparison comparison = new Comparison();
                }
                else {
                    System.out.println("Невозможно выполнить команду. Считайте годовой отчет." );
                }

            }*/
            else {
                System.out.println("Такой команды нет" );
            }

        }
    }



    static void printMenu() {
        System.out.println("\n"+
                "Что вы хотите сделать ?\n" +
                "\n" +
                "1- Считать все месячные отчёты.\n" +
                "2- Считать годовой отчёт.\n" +
                "3- Сверить отчёты.\n" +
                "4- Вывести информацию о всех месячных отчётах.\n" +
                "5- Вывести информацию о годовом отчёте.\n" +
                "\n" );
    }


}