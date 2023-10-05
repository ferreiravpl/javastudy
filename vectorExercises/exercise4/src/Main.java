import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        //Criação do array de números e inserção dos valores escolhidos pelo usuário
        System.out.print("Quantos números você irá digitar? ");
        int qtNumeros = sc.nextInt();
        double[] vetorNumeros = new double[qtNumeros];

        for (int i = 0; i < vetorNumeros.length; i++) {
            System.out.print("Digite o número: ");
            vetorNumeros[i] = sc.nextInt();
        }

        //Validação de quantidade de números pares no array
        int qtNumerosPares = 0;

        for (int i = 0; i < vetorNumeros.length; i++) {
            if (vetorNumeros[i] % 2 == 0) {
                qtNumerosPares++;
             }
        }

        System.out.println("Quantidade de números pares: " + qtNumerosPares);

        //Validação de quais são os números pares no array
        System.out.print("Números pares digitados pelo usuário: ");

        for (int i = 0; i < vetorNumeros.length; i++) {
            if (vetorNumeros[i] % 2 == 0) {
                System.out.println();
                System.out.printf("%.1f ", vetorNumeros[i]);
            }
        }

        sc.close();
    }
}