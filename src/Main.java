import Deals.Deal;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Deal deal = new Deal();


        printMenu();
        int param = scanner.nextInt();


        while (param != 0) {

            switch (param) {
                case 1:
                    deal.faker();

                    System.out.println("Введите значение от 0-" + menuPositions);
                    param = scanner.nextInt();
                    break;
                case 11 :
                    deal.addDeal();
                    System.out.println("Введите значение от 0-" + menuPositions);
                    param = scanner.nextInt();
                    break;

                case 2:
                    System.out.println("Введите номер сделки которую хотите [Изменить]");
                    deal.showDealList();
                    int updateDeal = scanner.nextInt();
                    scanner.nextLine();
                    deal.updateDeal(updateDeal);
                    System.out.println("Введите значение от 0-" + menuPositions);
                    param = scanner.nextInt();
                    break;

                case 3:
                    System.out.println("Введите номер здачи которую хотите [Удалить]");
                    int index = scanner.nextInt();
                    deal.deleteDeal(index);
                    System.out.println("Введите значение от 0-" + menuPositions);
                    param = scanner.nextInt();
                    break;
                case 4:

                    deal.showDealList();
                    System.out.println("Введите значение от 0-" + menuPositions);
                    param = scanner.nextInt();
                    break;

                case 5:
                    System.out.println("Введите номер задачи которую хотите закрыть ");
                    int closeDeal = scanner.nextInt();

                    deal.closeDeal(closeDeal);
                    System.out.println("Введите значение от 0-" + menuPositions);
                    param = scanner.nextInt();
                    break;

                case 6:
                    if (Deal.getDealsList().isEmpty()) {
                        System.out.println("У вас нет сделок ");
                        System.out.println("Введите значение от 0-" + menuPositions);
                        param = scanner.nextInt();
                        break;
                    } else {


                        deal.filteringDeal();
                        System.out.println("Введите значение от 0-" + menuPositions);
                        param = scanner.nextInt();
                        break;
                    }
                    /**
                     case 7:
                     statistic.getDealsStatistic();
                     System.out.println("Введите значение от 0-" + menuPositions);
                     param = scanner.nextInt();

                     break;

                     */
                case 0:
                    param = 0;
            }

        }


    }

    public static int menuPositions = 6;

    public static void printMenu() {

        System.out.println(

                "1: Создать сделку " + "\n" +
                        "2: Отредактировать сделку    " + "\n" +
                        "3: Удалить сделку" + "\n" +
                        "4: Список сделок " + "\n" +
                        "5: Закрыть сделку  " + "\n" +
                        "6: Найти  сделку  " + "\n" +
                        //     "7: Получить статистику  " + "\n" +
                        "0: Выйти" + "\n"


        );
    }
}