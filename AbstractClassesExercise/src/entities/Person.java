package entities;

public abstract class Person {

    private String name;
    Double taxesPerAnualIncome;
    private Double tax;

    public Person() {

    }

    public Person(String name, Double taxesPerAnualIncome) {
        this.name = name;
        this.taxesPerAnualIncome = taxesPerAnualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTaxesPerAnualIncome() {
        return taxesPerAnualIncome;
    }

    public void setTaxesPerAnualIncome(Double taxesPerAnualIncome) {
        this.taxesPerAnualIncome = taxesPerAnualIncome;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public void taxesCalculator() {
    }

    public abstract String toString();

}
