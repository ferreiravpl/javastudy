package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int numberOfProducts = sc.nextInt();

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Product #" + (i + 1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char productNature = sc.next().charAt(0);
            sc.nextLine();
            if (productNature == 'i') {
                System.out.print("Name: ");
                String productName = sc.nextLine();
                System.out.print("Price: ");
                Double productPrice = sc.nextDouble();
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                productList.add(new ImportedProduct(productName, productPrice, customsFee));
            } else if (productNature == 'c') {
                System.out.print("Name: ");
                String productName = sc.nextLine();
                System.out.print("Price: ");
                Double productPrice = sc.nextDouble();
                productList.add(new Product(productName, productPrice));
            } else {
                System.out.print("Name: ");
                String productName = sc.nextLine();
                System.out.print("Price: ");
                Double productPrice = sc.nextDouble();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                productList.add(new UsedProduct(productName, productPrice, manufactureDate));
            }

        }

        System.out.println("PRICE TAGS:");

        for (Product prod : productList) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}