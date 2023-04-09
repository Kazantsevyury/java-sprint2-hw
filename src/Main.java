import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);

        while (true){
            printMenu();
            int command = scanner.nextInt();

            if (command == 1 ) {
                String filePath = "m.202103.csv";
                Reader reader = new Reader();
                List<String> fileContents = reader.readFileContents(filePath);

                Month month = new Month(fileContents);
                month.process();


            } else if (command == 2 ) {
                String filePath = "resources/y.2021.csv";
                Reader reader = new Reader();
                List<String> fileContents = reader.readFileContents(filePath);

                Year year = new Year(fileContents);
                year.process();


            } else if (command == 3) {





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

