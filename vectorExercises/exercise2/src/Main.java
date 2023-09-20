import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        double soma, media;

        System.out.print("Quantos números você vai digitar? ");
        int qtNumeros = sc.nextInt();
        double[] vect = new double[qtNumeros];

        for (int i = 0; i < vect.length; i++) {
            System.out.println("Digite um número: ");
            vect[i] = sc.nextDouble();
        }


        soma = 0;
        for (int i = 0; i < vect.length; i++) {
            soma = soma + vect[i];
        }

        media = soma / qtNumeros;

        System.out.print("VALORES = ");

        for (int i=0; i<vect.length; i++) {
            System.out.printf("%.1f  ", vect[i]);
        }

        System.out.printf("\nSOMA = %.2f\n", soma);
        System.out.printf("MEDIA = %.2f\n", media);

        sc.close();
    }
}