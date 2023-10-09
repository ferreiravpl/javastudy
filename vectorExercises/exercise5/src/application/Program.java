package application;
import entities.Renter;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        //Criando array de quartos totais
        double[] rentableRooms = new double[9];

        //Criando array de quartos que serão alugados
        System.out.print("How many roms will be rented? ");
        int roomsToRent = sc.nextInt();
        Renter[] rentedRooms = new Renter[roomsToRent];

        for (int i = 0; i < rentedRooms.length; i++) {
            System.out.println("Rent #" + (i + 1) + ":");
            sc.nextLine();
            System.out.print("Name: ");
            String renterName = sc.nextLine();
            System.out.print("Email: ");
            String renterEmail = sc.nextLine();
            System.out.print("Room: ");
            int roomNumber = sc.nextInt();
            rentedRooms[i] = new Renter(renterName, renterEmail, roomNumber);
        }

        //Validação de quais quartos estão alugados em ordem crescente
        int busyRooms = 0;
        System.out.println("Busy rooms:");

        for (int i = 0; i < rentedRooms.length; i++) {
            if (rentedRooms[i] != null) {
                System.out.println(rentedRooms[i].getRoomNumber() + ": " + rentedRooms[i].getName() + ", " + rentedRooms[i].getEmail());
                busyRooms++;
            }
            else {
                System.out.println("No rented rooms.");
            }
        }

        sc.close();
    }
}
