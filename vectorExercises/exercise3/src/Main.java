import entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.print("Quanta pessoas serão digitadas? ");
        int qtdPessoas = sc.nextInt();
        double[] vect = new double[qtdPessoas];

        for (int i = 0; i < vect.length; i++) {
            System.out.println("Dados da " + vect[i] + "a pessoa:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            Pessoa pessoa = new Pessoa(nome, idade, altura);
        }


        sc.close();
    }
}