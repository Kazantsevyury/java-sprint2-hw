import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        is

        while (true){
            printMenu();
            int command = scanner.nextInt();

            if (command == 1 ) {
                for (int i = 1; i <= 3; i++) {
                    String string = String.format("%02d", i);
                    Month month = new Month(string);
                    month.parsing("resources/m.2021" + string + ".csv");
                }



            } else if (command == 2 ) {
                Year year2021 = new Year();
                year2021.parsing(); ;

            } else if (command == 3) {
                Year year2021 = new Year();
                year2021.getSum();




            }else if (command == 4 ) {

            }else if (command == 5 ) {

            } else if (command == 721) {
                break;
            }
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

