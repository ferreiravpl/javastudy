package application;
import entities.Renter;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        //Criando array de quartos que serão alugados
        Renter[] rentedRooms = new Renter[10];
        System.out.print("How many roms will be rented? ");
        int roomsToRent = sc.nextInt();

        for (int i = 0; i <= roomsToRent; i++) {
            System.out.println("Rent #" + (i + 1) + ":");
            sc.nextLine();
            System.out.print("Name: ");
            String renterName = sc.nextLine();
            System.out.print("Email: ");
            String renterEmail = sc.nextLine();
            System.out.print("Room: ");
            int roomNumber = sc.nextInt();
            rentedRooms[roomNumber] = new Renter(renterName, renterEmail, roomNumber);
            System.out.println();
        }

        //Validação de quais quartos estão alugados em ordem crescente
        int busyRooms = 0;
        System.out.println("Busy rooms:");

        for (int i = 0; i < rentedRooms.length; i++) {
            if (rentedRooms[i] != null) {
                System.out.println(rentedRooms[i].getRoomNumber() + ": " + rentedRooms[i].getName() + ", " + rentedRooms[i].getEmail());
                busyRooms++;
            }
        }

        sc.close();
    }
}
