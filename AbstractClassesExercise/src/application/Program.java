package application;

import java.util.Scanner;

import entities.Person;
import entities.PhysicalPerson;
import entities.LegalPerson;

import java.util.List;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        Integer taxPayersQty = sc.nextInt();

        for (int i = 1; i <= taxPayersQty; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char personType = sc.next().charAt(0);
            if (personType == 'c') {
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Anual income: ");
                Double anualIncome = sc.nextDouble();
                System.out.print("Number of employees: ");
                Integer employeeQty = sc.nextInt();
                sc.nextLine();
                taxPayers.add(new LegalPerson(name, anualIncome, employeeQty));
            } else {
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Anual income: ");
                Double anualIncome = sc.nextDouble();
                System.out.print("Health expenses: ");
                Double healthExpenses = sc.nextDouble();
                taxPayers.add(new PhysicalPerson(name, anualIncome, healthExpenses));
            }
        }

        for (Person person : taxPayers) {

            System.out.println("TAXES PAID:");
            System.out.println(person);

        }
        sc.close();
    }

}