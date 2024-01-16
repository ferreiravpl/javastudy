package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String filePath = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            List<Employee> employeeList = new ArrayList<>();
            String csvLine = br.readLine();
            while (csvLine != null) {
                String[] fields = csvLine.split(",");
                String employeeName = fields[0];
                String employeeEmail = fields[1];
                Double employeeSalary = Double.valueOf(fields[2]);
                employeeList.add(new Employee(employeeName, employeeEmail, employeeSalary));
                br.readLine();
            }

        }

        catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();

    }
}
