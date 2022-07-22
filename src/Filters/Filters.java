package Filters;

import Deals.Deal;
import Deals.DealResult;

import java.util.Scanner;

public class Filters {

    Scanner scanner = new Scanner(System.in);
    private String filteredCoinName;
    private DealResult filteredDealResult;


    public void coinNameFilter() {
        System.out.println("Введите название монет для поиска : ");
        filteredCoinName = scanner.nextLine();
        for (int i = 0; i < Deals.Deal.getDealsList().size(); i++) {

            if (Deals.Deal.getDealsList().get(i).getCoinName().equalsIgnoreCase(filteredCoinName)) {

                System.out.println(Deals.Deal.getDealsList().get(i).toString(i));
            }


        }

    }


    public void dealResultFilter(DealResult dealResult) {


        filteredDealResult = dealResult;


        for (int i = 0; i < Deals.Deal.getDealsList().size(); i++) {

            if (Deals.Deal.getDealsList().get(i).getDealResult() == filteredDealResult) {

                System.out.println(Deals.Deal.getDealsList().get(i).toString(i));
            }


        }

    }


    public void dateFilter() {
        System.out.println("1. Фильтр по [Дате открытия]");
        System.out.println("2. Фильтр по [Дате закрытия]");
        System.out.println("3. Фильтр [За  период]");

        switch (scanner.nextInt()) {

            case 1:
                System.out.println("ДД.ММ.ГГ");
                scanner.nextLine();
                String newDate = scanner.nextLine();

                for (int i = 0; i < Deals.Deal.getDealsList().size(); i++) {
                    if (Deals.Deal.getDealsList().get(i).getStartDate().equalsIgnoreCase(newDate)) {
                        System.out.println(Deals.Deal.getDealsList().get(i).toString(i));


                    }
                }
            break;

            case 2:
            case 3:
        }
    }


}
