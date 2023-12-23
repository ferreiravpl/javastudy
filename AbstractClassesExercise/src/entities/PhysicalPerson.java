package entities;

public class PhysicalPerson extends Person {

    private Double healthExpenses;

    public PhysicalPerson() {

    }

    public PhysicalPerson(String name, Double anualIncome, Double healthExpenses) {
        super(name, anualIncome);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public void taxesCalculator() {

        if (getTaxesPerAnualIncome() <= 20000) {
            setTax(0.15);
            taxesPerAnualIncome = getTaxesPerAnualIncome() * getTax() - getHealthExpenses() / 2;

        } else {
            setTax(0.25);
            taxesPerAnualIncome = getTaxesPerAnualIncome() * getTax() - getHealthExpenses() / 2;
        }

    }

    @Override
    public String toString() {
        return getName()
                + ": $ "
                + getTaxesPerAnualIncome();

    }

}
