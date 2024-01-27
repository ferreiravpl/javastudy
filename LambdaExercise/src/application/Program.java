package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String filePath = sc.nextLine();
        System.out.print("Enter salary: ");
        Double salary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            List<Employee> employeeList = new ArrayList<Employee>();
            String csvLine = br.readLine();
            while (csvLine != null) {
                String[] fields = csvLine.split(",");
                String employeeName = fields[0];
                String employeeEmail = fields[1];
                Double employeeSalary = Double.valueOf(fields[2]);
                employeeList.add(new Employee(employeeName, employeeEmail, employeeSalary));
                csvLine = br.readLine();
            }
            List<String> filteredEmail = employeeList.stream()
                    .filter(p -> p.getSalary() > salary)
                    .map(p -> p.getEmail())
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");
            filteredEmail.forEach(System.out::println);

            double sum = employeeList.stream()
                    .filter(p -> p.getName().charAt(0) == 'M')
                    .map(p -> p.getSalary())
                    .reduce(0.0, (x,y) -> x + y);

            System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("%.2f", sum));

        }

        catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();

    }
}
