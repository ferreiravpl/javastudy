package entities;
public class Transactions {

    protected static Double cost;
    protected static Double paidAmount;

    public Transactions() {

    }

    public static Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public static Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }
}
