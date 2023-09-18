import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos números você vai digitar? ");
        int qtVetor = sc.nextInt();
        double[] vect = new double[qtVetor];

        for (int numero = 0; numero < vect.length; numero++) {
            System.out.print("Digite um número: ");
            vect[numero] = sc.nextDouble();
        }
        for (int i = 0; i < vect.length; i++) {
            if (vect[i] < 0) {
                System.out.println("Numeros negativos: " + vect[i]);
            } sc.close();
        }
    }
}