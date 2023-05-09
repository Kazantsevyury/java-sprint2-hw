package controller;
import data.MonthReportStorage;
import data.YearReportStorage;
import logic.*;

import java.util.Scanner;

public class AppController {
    int ACTUAL_YEAR = 2021;
    private final YearReportLoader yearReportLoader;
    private final YearReportMaker yearReportMaker;
    private final MonthReportLoader monthReportLoader;
    private final  DataReconciliationMaker dataReconciliationMaker;
    private final MonthsReportMaker monthsReportMaker;
    public  AppController()
    {

        YearReportStorage yearReportStorage = new YearReportStorage(ACTUAL_YEAR);
        yearReportLoader = new YearReportLoader(yearReportStorage,ACTUAL_YEAR);
        yearReportMaker = new YearReportMaker(yearReportStorage,ACTUAL_YEAR);

        MonthReportStorage monthReportStorage = new MonthReportStorage(ACTUAL_YEAR);
        monthReportLoader = new MonthReportLoader(monthReportStorage,ACTUAL_YEAR);
        monthsReportMaker = new MonthsReportMaker(monthReportStorage,ACTUAL_YEAR);

        dataReconciliationMaker = new DataReconciliationMaker(yearReportStorage,monthReportStorage,ACTUAL_YEAR);


    }
    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        String command ;

        boolean exitFlag = false;
        boolean isYearRepUp = false;
        boolean isMonthRepUp = false;

        while (!exitFlag) {
            printMenu();
            try {



            command = scanner.nextLine();
            if (command.equals("root")) {
                System.out.println("Выход из программы...");
                exitFlag = true;
            }
            else if (command.equals("1")  ) {
                isMonthRepUp = true;
                monthReportLoader.load();
            }
            else if (command.equals("2")  ) {
                isYearRepUp = true;
                yearReportLoader.load();
            }
            else if (command.equals("3") ) {
                if (isYearRepUp && isMonthRepUp ) {
                    dataReconciliationMaker.printDataReconciliation();
                }
                else {
                    System.out.println("Невозможно выполнить команду. Считайте месячный и годовой отчеты." );
                }
            }
            else if (command.equals("4")  ) {
                if ( isMonthRepUp ) {
                    monthsReportMaker.printMonthReport();
                }
                else {
                    System.out.println("Невозможно выполнить команду. Считайте месячные отчеты." );
                }

            }
            else if (command.equals("5")  ) {
            if (isYearRepUp ) {
                yearReportMaker.printMonthInYearReport();
            }
            else {
                System.out.println("Невозможно выполнить команду. Считайте годовой отчет." );
            }
            }
            else {
            System.out.println("Такой команды нет" );
            }
            }
            catch (IllegalArgumentException e){
                System.err.println("Ошибка: " + e.getMessage());
            }catch (NullPointerException e) {
                System.out.println("Ошибка: объект равен null");
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    private void printMenu() {
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