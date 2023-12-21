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
    public double taxesCalculator() {

        if (getAnualIncome() <= 20000) {
            tax = 0.15;
            return anualIncome = anualIncome * tax - getHealthExpenses() / 2;

        } else {
            tax = 0.25;
            return anualIncome = anualIncome * tax - getHealthExpenses() / 2;
        }

    }

    @Override
    public String toString() {
        return "PhysicalPerson{" +
                "name='" + name + '\'' +
                ", anualIncome=" + anualIncome +
                ", tax=" + tax +
                '}';
    }

}
