package application;

import entities.Client;
import entities.OrderItem;
import entities.Product;
import entities.Order;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name, email, birthDate);
        System.out.println("Enter order data:");
        sc.nextLine();
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(sc.next());
        Order order = new Order(new Date(), orderStatus, client);
        System.out.print("How many items to this order? ");
        Integer itemsQty = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= itemsQty; i++) {
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer productQuantity = sc.nextInt();
            Product product = new Product (productName, productPrice);
            OrderItem orderItem = new OrderItem (productQuantity, productPrice, product);
            order.addItem(orderItem);
            sc.nextLine();
        }
        System.out.println();
        System.out.println(order);

        sc.close();
    }
}