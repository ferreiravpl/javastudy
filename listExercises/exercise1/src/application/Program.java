package application;
import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        //Criação da lista
        System.out.print("How many employees will be registered? ");
        int employeeQty = sc.nextInt();
        List<Employee> employeeList = new ArrayList<>();

        //Laço para percorrer a lista e inserir os employees
        for (int i = 0; i < employeeQty; i++) {
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            System.out.println();
            Employee emp = new Employee(id, name, salary);
            employeeList.add(emp);
        }

        //Validação de aumento de salarío por id
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Employee emp = employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("This id does not exist!");
        }
        else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println("List of employees:");
        for (Employee e : employeeList) {
            System.out.println(e);
        }

        sc.close();

    }
}
