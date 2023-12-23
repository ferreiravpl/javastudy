package entities;

public class LegalPerson extends Person {

    private Integer employeeQuantity;

    public LegalPerson() {

    }

    public LegalPerson(String name, Double anualIncome, Integer employeeQuantity) {
        super(name, anualIncome);
        this.employeeQuantity = employeeQuantity;
    }

    public Integer getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(Integer employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    @Override
    public void taxesCalculator() {
        setTax(0.16);
        if (getEmployeeQuantity() >= 10) {
            setTax(0.14);
            taxesPerAnualIncome *= getTax();
        } else {
            taxesPerAnualIncome *= getTax();
        }
    }

    @Override
    public String toString() {
        return getName()
                + ": $ "
                + getTaxesPerAnualIncome();
    }

}
