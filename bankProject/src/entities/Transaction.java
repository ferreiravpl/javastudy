package entities;

public class Transaction {

    public static double deposit;
    public static double withdraw;

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw + 5;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }
}
