package Deals;


import Filters.Filters;
import Utils.DataCreater;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deal {

    Filters filters = new Filters();
    public Scanner scanner = new Scanner(System.in);

    DataCreater dataCreater = new DataCreater();


    private DealType dealType;
    private String coinName;
    private DealStatus dealStatus = DealStatus.ACTIVE;
    private DealResult dealResult = DealResult.IN_PROGRESS;
    private double startPrice;
    private double endPrice;
    private String coment;

    private String startDate;
    private String endDate;

    private String startTime;
    private String endTime = "";

    public double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(double endPrice) {
        this.endPrice = endPrice;
    }


    private int profit;

    private boolean perp = false;


    static List<Deal> dealsList = new ArrayList<>();

    public Deal() {

    }

    public Deal(String coin, DealType dealType, double startPrice, double endPrice) {
        this.dealType = dealType;
        this.coinName = coin;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
        this.startDate = dataCreater.getDateDeal();
        this.startTime = dataCreater.getTimeDeal();


    }

    public Deal(String coin, DealType dealType, double startPrice, String coment) {
        this.dealType = dealType;
        this.coinName = coin;
        this.startPrice = startPrice;
        this.startDate = dataCreater.getDateDeal();
        this.startTime = dataCreater.getTimeDeal();
        this.coment = coment;

    }

    public Deal(String coin, DealType dealType, double startPrice, DealResult dealResult) {
        this.dealType = dealType;
        this.coinName = coin;
        this.startPrice = startPrice;
        this.startDate = dataCreater.getDateDeal();
        this.startTime = dataCreater.getTimeDeal();
        this.dealResult = dealResult;


    }


    public void addDeal() throws IOException {


        System.out.println("???????????????? ???????????? : ");
        String coin = scanner.nextLine();
        System.out.println("?????? ???????????? : ");
        DealType type = chooseDealType();
        System.out.println("???????? ?????????? (0,0) :");
        double price = scanner.nextDouble();

        System.out.println("???????? ???????????????? (0,0) :");
        double finishPrice = scanner.nextDouble();

        dealsList.add(new Deal(coin.toUpperCase(), type, price, finishPrice));

        System.out.println("???????????? ?????????????? ?????????????? !");


        showDealList();

        System.out.println(" ");

        scanner.nextLine();
    }

    public void deleteDeal(int dealNumber) {
        int startSize = dealsList.size();
        dealsList.remove(dealNumber);

        if (startSize != dealsList.size()) {
            System.out.println("???????????? ?????????????? ??????????????!");
        } else {
            System.out.println("???? ?????????????? ?????????????? ????????????!");
        }
    }

    public void updateDeal(int dealIndex) {

        printDealFields();


        int param = scanner.nextInt();


        while (param != 0) switch (param) {
            case 1:
                //change coin name
                System.out.println("?????????????? ?????????? ???????????????? ????????????:");
                scanner.nextLine();

                String newCoinName = scanner.nextLine();
                getDeal(dealIndex).setCoinName(newCoinName.toUpperCase());
                param = 0;
                break;
            case 2:
                //change deal type ("S/L")
                System.out.println("???????????????? ?????????? ?????? ????????????:");
                getDeal(dealIndex).setDealType(chooseDealType());
                param = 0;
                break;


            case 3:
                //change deal stage  (PROFIT,FAIL,IN_PROGRESS,FREE)
                System.out.println("???????????????? ?????????? ?????????????????? ????????????: ");
                getDeal(dealIndex).setDealResult(chooseDealResult());
                setDealProfit(dealIndex);
                param = 0;
                break;

            case 4:
                //change deal status (ACTIVE,CLOSE)

                getDeal(dealIndex).setDealStatus(chooseDealStatus());
                // writeComent(dealIndex);

                scanner.nextLine();
                param = 0;
                break;

            case 5:
                //change price

                System.out.println("?????????????? ?????????? ???????????????? ???????? ??????????:");
                scanner.nextLine();
                double newStartPrice = scanner.nextDouble();
                dealsList.get(dealIndex).setStartPrice(newStartPrice);
                param = 0;
                break;


            case 6:
                //change startDate
                System.out.println("?????????????? ?????????? ???????? ???????????????? :");
                System.out.println("????????????: DD.MM.YY");
                scanner.nextLine();
                String newStartDate = scanner.nextLine();
                dealsList.get(dealIndex).setStartDate(newStartDate);
                param = 0;
                break;


            case 7:
                //change endDate

                System.out.println("?????????????? ?????????? ???????? ???????????????? :");
                System.out.println("????????????: DD.MM.YY");
                scanner.nextLine();
                String newEndDate = scanner.nextLine();
                dealsList.get(dealIndex).setEndDate(newEndDate);

                param = 0;
                break;
                /*

                //change coment
                System.out.println("???????????? ???????????? : " +getComent());
                System.out.println("?????????????? ?????????? ???????? ????????????????????:");
                scanner.nextLine();
                String newComent = scanner.nextLine();
                getDeal(dealIndex).setComent(newComent);
                param = 0;
                break;
*/

        }

    }


    public void closeDeal(int dealIndex) {
        if (getDeal(dealIndex).getDealStatus().equals(DealStatus.ACTIVE)) {

            getDeal(dealIndex).setDealStatus(DealStatus.CLOSE);
            System.out.println("???????????????? ?????????????????? ???????????? : ");
            getDeal(dealIndex).setDealResult(chooseDealResult());
            scanner.nextLine();
            getDeal(dealIndex).setEndDate(dataCreater.getDateDeal());
            getDeal(dealIndex).setEndTime(dataCreater.getTimeDeal());

            setDealProfit(dealIndex);

            System.out.println("???????????????? ????????????????????");
            scanner.nextLine();
            getDeal(dealIndex).setComent(scanner.nextLine());


        } else {
            System.out.println("?????????????????? ???????????? ?????? ?????????????? ");
        }
    }


    public void filteringDeal() {
        System.out.println("1: ?????????? ???? [???????????????? ????????????]");
        System.out.println("2: ?????????? ???? [???????????????????? ????????????]");
        System.out.println("3: ?????????? ???? [???????? ????????????]");

        int filterType = scanner.nextInt();

        switch (filterType) {
            case 1:

                filters.coinNameFilter();

                break;
            case 2:
                System.out.println("???????????????? ?????????????????? ????????????  : ");
                chooseDealResult();
                filters.dealResultFilter(getDealResult());
                break;
            case 3:
                filters.dateFilter();
                break;
        }
    }


    public void showDealList() {

        for (int i = 0; i < dealsList.size(); i++) {
            System.out.println(dealsList.get(i).toString(i));
        }






       /*
        System.out.print("??????????????: " + finance.countAllDeposit() + "$,  ");
        System.out.print("????????????: " + finance.countDealsDeposit() + "$,  " + "\n");
        if (perp == true)
            System.out.println("???? ???????? ????????????????: " + finance.perpouseDeposit() + "$,  ");

        */
    }

    public void faker() {
        System.out.println("Fake data was created");

        dealsList.add(new Deal("ETH", DealType.LONG, 3444, "?????????????????? ????????????"));
        dealsList.add(new Deal("BTC", DealType.LONG, 55000, "?????????????????? ????????????"));
        dealsList.add(new Deal("ADA", DealType.LONG, 2.33, DealResult.PROFIT));
        dealsList.add(new Deal("ICP", DealType.SHORT, 0.44, DealResult.PROFIT));
        dealsList.add(new Deal("DOT", DealType.SHORT, 0.44, DealResult.PROFIT));
        dealsList.add(new Deal("ADA", DealType.SHORT, 0.44, DealResult.PROFIT));
        dealsList.add(new Deal("RUNA", DealType.SHORT, 0.44, DealResult.PROFIT));


    }


    private void setDealProfit(int dealIndex) {
        int profit;
        if (getDeal(dealIndex).getDealResult().equals(DealResult.PROFIT)) {
            System.out.println("?????????????? ?????????????? ?? ???????????? ");

            profit = scanner.nextInt();
            getDeal(dealIndex).setProfit(profit);
        } else if (getDeal(dealIndex).getDealResult().equals(DealResult.FAIL)) {
            System.out.println("?????????????? ???????????? ?? ???????????? ");

            profit = scanner.nextInt();
            getDeal(dealIndex).setProfit((profit));
        } else
            getDeal(dealIndex).setProfit(0);
    }

    private DealType chooseDealType() {

        System.out.println("1: LONG");
        System.out.println("2: SHORT");

        int type = scanner.nextInt();

        switch (type) {

            case 1:
                dealType = DealType.LONG;
                break;


            case 2:
                dealType = DealType.SHORT;
                break;

        }
        return dealType;
    }

    private DealStatus chooseDealStatus() {
        System.out.println("1: ACTIVE");
        System.out.println("2: CLOSE");

        int status = scanner.nextInt();

        switch (status) {

            case 1:
                dealStatus = DealStatus.ACTIVE;
                break;


            case 2:
                dealStatus = DealStatus.CLOSE;
                break;


        }
        return dealStatus;

    }

    private DealResult chooseDealResult() {

        System.out.println("1: PROFIT");
        System.out.println("2: FAIL");
        System.out.println("3: FREE");
//        System.out.println("4: IN_PROGRESS");
        int type = scanner.nextInt();

        switch (type) {

            case 1:
                dealResult = DealResult.PROFIT;
                break;


            case 2:
                dealResult = DealResult.FAIL;
                break;


            case 3:
                dealResult = DealResult.FREE;
                break;

        }
        return dealResult;
    }

    public String toString(int index) {
        return "Deals.Deal{" + " ??? " + index + '\'' + ",  ??????_??????: " + getDeal(index).getStartDate() + getDeal(index).getStartTime() + ",  ??????_??????: " + getDeal(index).getEndDate() + getDeal(index).getEndTime() + ",  ?????????? : '" + coinName + '\'' + ",  ?????? : " + dealType + ",  ??????????????????_???????????? : " + dealResult + '(' + getDeal(index).getProfit() + "$" + ')' + ",  ???????????? :" + dealStatus + ",  ????????_?????????? : " + startPrice + ",  ????????_???????????????? : " + endPrice + ",  ????????????: " + getComent() + '}';
    }

    private void printDealFields() {

        System.out.println("1: ???????????? ");
        System.out.println("2: ??????");
        System.out.println("3: ?????????????????? ????????????");
        System.out.println("4: ????????????");
        System.out.println("5: ???????? ??????????");
        System.out.println("6: ???????? ???????????????? ");
        System.out.println("7: ???????? ???????????????? ");
    }

    private Deal getDeal(int dealIndex) {
        return dealsList.get(dealIndex);
    }

    /**
     * GETTERS AND SETTERS
     */

    public DealType getDealType() {
        return dealType;
    }

    public String getCoinName() {
        return coinName;
    }

    public DealStatus getDealStatus() {
        return dealStatus;
    }

    public DealResult getDealResult() {
        return dealResult;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public void setDealType(DealType dealType) {
        this.dealType = dealType;
    }

    public void setDealStatus(DealStatus dealStatus) {
        this.dealStatus = dealStatus;
    }

    public void setDealResult(DealResult dealResult) {
        this.dealResult = dealResult;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }


    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public void setProfit(int profit) {
        this.profit = profit;
    }


    public int getProfit() {
        return profit;
    }

    public static List<Deal> getDealsList() {
        return dealsList;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
