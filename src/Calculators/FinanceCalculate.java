package Calculators;


import Deals.Deal;

public class FinanceCalculate {

    private int deposit = 100;
    private int perpouseDep = 2000;

    public int countAllDeposit() {

        for (int i = 0; i < Deal.getDealsList().size(); i++) {
            deposit += Deal.getDealsList().get(i).getProfit();
        }
        return deposit;
    }

    public int countDealsDeposit() {
        int newDep = 0;
        for (int i = 0; i < Deal.getDealsList().size(); i++) {
            newDep += Deal.getDealsList().get(i).getProfit();
        }
        return newDep;
    }

    public int perpouseDeposit() {
        return perpouseDep - deposit;
    }
}
