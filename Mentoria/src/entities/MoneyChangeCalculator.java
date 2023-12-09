package entities;

import java.util.ArrayList;
import java.util.List;

public class MoneyChangeCalculator extends Transactions {

    public List<Double> noteList = new ArrayList<>();

    public MoneyChangeCalculator() {

    }

    public Double calculateMoneyChange () {
        return Transactions.getPaidAmount() - Transactions.getCost();
    }

}
