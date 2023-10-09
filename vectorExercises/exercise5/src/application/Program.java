package application;
import entities.Renter;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        //Criação do array de quartos totais
        double[] rentableRooms = new double[9];

        //Criação do array de quartos que serão alugados
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

        sc.close();
    }
}
