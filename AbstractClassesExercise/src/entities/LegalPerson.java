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
    public double taxesCalculator() {
        tax = 0.16;
        if (getEmployeeQuantity() >= 10) {
            tax = 0.14;
            return anualIncome *= tax;
        } else {
            return anualIncome *= tax;
        }
    }
}
