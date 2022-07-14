package Statistic;

import Deals.Deal;
import Deals.DealResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Statistic {

//      (профитные\ проиграные\ безубыточне с.   /  общее кол- во с. ) * 100

    Deal deals = new Deal();
    List<Deal> profitDeal = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    double stata = 0;


    double procent = 100;


    public void getDealsStatistic() {
        System.out.println("Выберите статистику ");
        System.out.println("1: Статистика [Профитных] сделок");
        System.out.println("2: Статистика [Убыточных] сделок");
        System.out.println("3: Статистика [Безубыточных] сделок");

        int positionMenu = scanner.nextInt();
        switch (positionMenu) {

            case 1:
                System.out.println(getProfitDealsStatistic() + "%");
                stata = 0;
                break;

            case 2:

                System.out.println(getFailDealsStatistic() + "%");
                stata = 0;
                break;
            case 3:

                System.out.println(getFreeDealsStatistic() + "%");
                break;
        }
    }


    private double getProfitDealsStatistic() {

        double profitDeal = getResultsDeals(DealResult.PROFIT).size();
        stata = (profitDeal / Deal.getDealsList().size()) * procent;
        return stata;


    }

    private double getFailDealsStatistic() {

        double failDeal = getResultsDeals(DealResult.FAIL).size();
        stata = (failDeal / Deal.getDealsList().size()) * 100;
        return stata;
    }

    private double getFreeDealsStatistic() {

        double freeDeal = getResultsDeals(DealResult.FREE).size();
        return (freeDeal / Deal.getDealsList().size()) * 100;
    }

    private List<Deal> getResultsDeals(DealResult dealResult) {


        for (int i = 0; i < Deal.getDealsList().size(); i++) {
            if (Deal.getDealsList().get(i).getDealResult() == dealResult)
                profitDeal.add(Deal.getDealsList().get(i));
        }
        return profitDeal;
    }
}
