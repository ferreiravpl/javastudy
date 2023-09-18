package entities;

public class Account {

    Transaction tc = new Transaction();

    public String name;
    private int accountNumber;
    private double balance;
    public double initialDeposit;

    public Account (String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public Account () {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getBalance() {
        return balance + tc.getDeposit() - tc.getWithdraw();
    }

    public void setBalance(double balance) {
        if (initialDeposit != 0) {
            this.balance = initialDeposit;
        } else {
            this.balance = balance;
        }
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", initialDeposit=" + initialDeposit +
                ", balance=" + balance +
                '}';
    }
}
