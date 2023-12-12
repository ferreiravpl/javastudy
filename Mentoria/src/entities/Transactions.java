package entities;
public class Transactions {

    private static Double cost;
    private static Double paidAmount;

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
