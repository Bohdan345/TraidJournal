package Filters;

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


    }


}
